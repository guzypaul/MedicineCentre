package by.guzypaul.medicinecentre.dao.impl;

import by.guzypaul.medicinecentre.dao.exception.DaoException;
import by.guzypaul.medicinecentre.dao.mapper.DaoUserMapper;
import by.guzypaul.medicinecentre.dao.interfaces.UserDao;
import by.guzypaul.medicinecentre.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private static final String READ_ALL_USER_SQL = "SELECT users.id, users.name, " +
            "users.surname, users.password, users.email, " +
            "users.phone, users.role FROM users";
    private static final String READ_USER_BY_ID_SQL = "SELECT users.id, users.name, " +
            "users.surname, users.password, users.email, " +
            "users.phone, users.role FROM users WHERE users.id = ?";
    private static final String DELETE_USER_BY_ID_SQL = "DELETE FROM users WHERE users.id = ?";
    private static final String CREATE_USER_BY_ID_SQL = "INSERT INTO users (users.name," +
            "users.surname, users.password, users.email, users.phone, users.role) " +
            "VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_USER_BY_ID_SQL = "UPDATE users SET name = ?," +
            " surname = ?, password = ?, email = ?, phone = ?, role = ? " +
            "WHERE users.id = ?";

    private final DaoUserMapper daoUserMapper = new DaoUserMapper();
    private Connection connection;

    @Override
    public List<User> readAll() throws DaoException {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(READ_ALL_USER_SQL);
            List<User> userList = new ArrayList<>();
            while (resultSet.next()) {
                userList.add(daoUserMapper.mapUser(resultSet));
            }

            return userList;
        } catch (SQLException throwables) {
            throw new DaoException(throwables.getMessage());
        }
    }

    @Override
    public User readById(Integer id) throws DaoException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(READ_USER_BY_ID_SQL)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return daoUserMapper.mapUser(resultSet);

        } catch (SQLException throwables) {
            throw new DaoException(throwables.getMessage());
        }
    }

    @Override
    public boolean deleteById(Integer id) throws DaoException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_BY_ID_SQL)) {
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException throwables) {
            throw new DaoException(throwables.getMessage());
        }
    }

    @Override
    public boolean create(User entity) throws DaoException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE_USER_BY_ID_SQL)) {
            setUserEntity(entity, preparedStatement);
            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException throwables) {
            throw new DaoException(throwables.getMessage());
        }
    }

    @Override
    public boolean update(User entity) throws DaoException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_BY_ID_SQL)) {
            setUserEntity(entity, preparedStatement);
            preparedStatement.setInt(7, entity.getId());
            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException throwables) {
            throw new DaoException(throwables.getMessage());
        }
    }

    private void setUserEntity(User entity, PreparedStatement preparedStatement) throws SQLException { //todo change method's name
        preparedStatement.setString(1, entity.getName());
        preparedStatement.setString(2, entity.getSurname());
        preparedStatement.setString(3, entity.getPassword());
        preparedStatement.setString(4, entity.getEmail());
        preparedStatement.setString(5, entity.getPhone());
        preparedStatement.setString(6, entity.getRole());
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
