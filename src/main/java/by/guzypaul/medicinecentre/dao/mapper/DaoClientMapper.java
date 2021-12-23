package by.guzypaul.medicinecentre.dao.mapper;

import by.guzypaul.medicinecentre.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoClientMapper {
    public User mapClient (ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("client_id"));
        user.setSurname(resultSet.getString("client_surname"));
        user.setName(resultSet.getString("client_name"));
        user.setPassword(resultSet.getString("client_password"));
        user.setEmail(resultSet.getString("client_email")); ;
        user.setPhone(resultSet.getString("client_phone"));
        user.setRole(resultSet.getString("client_role"));

        return user;
    }
}