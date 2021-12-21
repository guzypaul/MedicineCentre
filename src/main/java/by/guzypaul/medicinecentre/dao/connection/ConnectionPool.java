package by.guzypaul.medicinecentre.dao.connection;

import by.guzypaul.medicinecentre.dao.reader.DataBasePropertiesReader;
import by.guzypaul.medicinecentre.dao.reader.DataBasePropertiesReaderException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {
    private static final AtomicBoolean INSTANCE_CREATED = new AtomicBoolean(false);
    private static final String CONNECTION_IS_NULL_ENTER_MESSAGE = "Connection cannot be null";
    private static final String INCORRECT_CONNECTION_ENTER_MESSAGE = "Return connection does not exist";
    private static final Lock INSTANCE_LOCK = new ReentrantLock();
    private static final Lock CONNECTION_LOCK = new ReentrantLock();
    private static final Condition CONNECTION_CONDITION = CONNECTION_LOCK.newCondition();
    private static ConnectionPool instance;
    private ArrayDeque<Connection> freeConnections;
    private ArrayDeque<Connection> busyConnections;
    private DataBasePropertiesReader propertiesReader;

    private ConnectionPool() throws ConnectionPoolException {
        freeConnections = new ArrayDeque<>();
        busyConnections = new ArrayDeque<>();
        try {
            propertiesReader = new DataBasePropertiesReader();
        } catch (DataBasePropertiesReaderException e) {
            throw new ConnectionPoolException(e);
        }
    }

    public int getFreeConnectionsSize() {
        return freeConnections.size();
    }

    public int getBusyConnectionsSize() {
        return busyConnections.size();
    }

    public static ConnectionPool getInstance() throws ConnectionPoolException {
        if (!INSTANCE_CREATED.get()) {
            try {
                INSTANCE_LOCK.lock();
                if (instance == null) {
                    instance = new ConnectionPool();
                    INSTANCE_CREATED.set(true);
                }
            } finally {
                INSTANCE_LOCK.unlock();
            }
        }

        return instance;
    }

    public void initializeConnectionPool(int connectionsNumber) throws ConnectionPoolException, ConnectionPoolException {
        try {
            CONNECTION_LOCK.lock();

            for (int i = 0; i < connectionsNumber; i++) {
                freeConnections.push(new ProxyConnection(DriverManager.getConnection(propertiesReader.readURL(),
                        propertiesReader.getProperties())));
            }
        } catch (SQLException e) {
            throw new ConnectionPoolException(e);
        } finally {
            CONNECTION_LOCK.unlock();
        }
    }

    public Connection acquireConnection() throws ConnectionPoolException {
        try {
            CONNECTION_LOCK.lock();
            if (freeConnections.isEmpty()) {
				CONNECTION_LOCK.unlock();
                CONNECTION_CONDITION.await();
				CONNECTION_LOCK.lock();
            }
            Connection connection = freeConnections.poll();
            busyConnections.push(connection);
            return connection;

        } catch (InterruptedException e) {
            throw new ConnectionPoolException(e);
        } finally {
            CONNECTION_LOCK.unlock();
        }
    }

    public void putBackConnection(Connection connection) throws ConnectionPoolException {
        if (connection == null) {
            throw new ConnectionPoolException(CONNECTION_IS_NULL_ENTER_MESSAGE);
        }

        try {
            CONNECTION_LOCK.lock();
            if (busyConnections.remove(connection)) {
                freeConnections.add(connection);
                if (!freeConnections.isEmpty()) {
                    CONNECTION_CONDITION.signal();
                }
            } else {
                throw new ConnectionPoolException(INCORRECT_CONNECTION_ENTER_MESSAGE);
            }
        } finally {
            CONNECTION_LOCK.unlock();
        }
    }

    public void closeConnections() throws ConnectionPoolException {
        try {
            CONNECTION_LOCK.lock();
			for (Connection connection : busyConnections) {
				ProxyConnection proxyConnection = (ProxyConnection) connection;
				proxyConnection.getConnection().close();
			}
            for (Connection connection : freeConnections) {
                ProxyConnection proxyConnection = (ProxyConnection) connection;
                proxyConnection.getConnection().close();
            }
            freeConnections = new ArrayDeque<>();
            busyConnections = new ArrayDeque<>();
        } catch (SQLException e) {
            throw new ConnectionPoolException(e);
        } finally {
            CONNECTION_LOCK.unlock();
        }
    }
}