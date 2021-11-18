package by.guzypaul.medicinecentre.dao.mapper;

import by.guzypaul.medicinecentre.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoUserMapper {
    public User mapUser (ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setSurname(resultSet.getString("surname"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("Password"));
        user.setEmail(resultSet.getString("email")); ;
        user.setPhone(resultSet.getString("phone"));
        user.setRole(resultSet.getString("role"));

        return user;
    }
}
