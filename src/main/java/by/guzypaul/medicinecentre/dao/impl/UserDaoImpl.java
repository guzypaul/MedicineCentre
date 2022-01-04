package by.guzypaul.medicinecentre.dao.impl;

import by.guzypaul.medicinecentre.dao.DaoException;
import by.guzypaul.medicinecentre.dao.connection.ConnectionPool;
import by.guzypaul.medicinecentre.dao.connection.ConnectionPoolException;
import by.guzypaul.medicinecentre.dao.interfaces.UserDao;
import by.guzypaul.medicinecentre.dao.mapper.DaoUserMapper;
import by.guzypaul.medicinecentre.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {
    private static final String READ_ALL_USER_SQL = "SELECT users.id AS user_id, users.name AS user_name, " +
            "users.surname, users.password, users.email, " +
            "users.phone, users.role FROM users";
    private static final String READ_USER_BY_ID_SQL = "SELECT users.id AS user_id, users.name AS user_name, " +
            "users.surname, users.password, users.email, " +
            "users.phone, users.role FROM users WHERE users.id = ?";
    private static final String DELETE_USER_BY_ID_SQL = "DELETE FROM users WHERE users.id = ?";
    private static final String CREATE_USER_BY_ID_SQL = "INSERT INTO users (users.name," +
            "users.surname, users.password, users.email, users.phone, users.role) " +
            "VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_USER_BY_ID_SQL = "UPDATE users SET name = ?," +
            " surname = ?, password = ?, email = ?, phone = ?, role = ? " +
            "WHERE users.id = ?";
    private static final String READ_USER_BY_EMAIL_SQL = "SELECT users.id AS user_id, users.name AS user_name, " +
            "users.surname, users.password, users.email, " +
            "users.phone, users.role FROM users WHERE users.email = ?";
    private static final String READ_USER_BY_PHONE_SQL = "SELECT users.id AS user_id, users.name AS user_name, " +
            "users.surname, users.password, users.email, " +
            "users.phone, users.role FROM users WHERE users.phone = ?";

    private final DaoUserMapper daoUserMapper = new DaoUserMapper();

    @Override
    public List<User> readAll() throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().acquireConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(READ_ALL_USER_SQL);
            List<User> userList = new ArrayList<>();
            while (resultSet.next()) {
                userList.add(daoUserMapper.mapUser(resultSet));
            }

            return userList;
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Optional<User> readById(Integer id) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().acquireConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(READ_USER_BY_ID_SQL)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return Optional.of(daoUserMapper.mapUser(resultSet));
            }

            return Optional.empty();
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Optional<User> readByEmail(String email) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().acquireConnection(); //todo вынести повторяющийся код в отдельный приватный метод
             PreparedStatement preparedStatement = connection.prepareStatement(READ_USER_BY_EMAIL_SQL)) {
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return Optional.of(daoUserMapper.mapUser(resultSet));
            }

            return Optional.empty();
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Optional<User> readByPhone(String phone) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().acquireConnection(); //todo вынести повторяющийся код в отдельный приватный метод
             PreparedStatement preparedStatement = connection.prepareStatement(READ_USER_BY_PHONE_SQL)){
            preparedStatement.setString(1, phone);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return Optional.of(daoUserMapper.mapUser(resultSet));
            }

            return Optional.empty();
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public boolean deleteById(Integer id) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().acquireConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_BY_ID_SQL)) {
            preparedStatement.setInt(1, id);

            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException | ConnectionPoolException throwables) {
            throw new DaoException(throwables.getMessage());
        }
    }

    @Override
    public boolean create(User entity) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().acquireConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_USER_BY_ID_SQL)) {
            fillUserData(entity, preparedStatement);

            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public boolean update(User entity) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().acquireConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_BY_ID_SQL)) {
            fillUserData(entity, preparedStatement);
            preparedStatement.setInt(7, entity.getId());

            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException(e);
        }
    }

    private void fillUserData(User entity, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, entity.getName());
        preparedStatement.setString(2, entity.getSurname());
        preparedStatement.setString(3, entity.getPassword());
        preparedStatement.setString(4, entity.getEmail());
        preparedStatement.setString(5, entity.getPhone());
        preparedStatement.setString(6, entity.getRole().toString());
    }
}
