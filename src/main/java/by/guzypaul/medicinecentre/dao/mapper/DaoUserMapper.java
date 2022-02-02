package by.guzypaul.medicinecentre.dao.mapper;

import by.guzypaul.medicinecentre.entity.Role;
import by.guzypaul.medicinecentre.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The type Dao user mapper.
 * @author Guziy Paul
 */
public class DaoUserMapper {
    /**
     * Map user user.
     *
     * @param resultSet the result set
     * @return the user
     * @throws SQLException the sql exception
     */
    public User mapUser (ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("user_id"));
        user.setSurname(resultSet.getString("surname"));
        user.setName(resultSet.getString("user_name"));
        user.setPassword(resultSet.getString("password"));
        user.setEmail(resultSet.getString("email"));
        user.setPhone(resultSet.getString("phone"));
        user.setRole(Role.valueOf(resultSet.getString("role").toUpperCase()));

        return user;
    }
}
