package by.guzypaul.medicinecentre.dao.interfaces;

import by.guzypaul.medicinecentre.dao.DaoException;
import by.guzypaul.medicinecentre.entity.User;

import java.util.Optional;

public interface UserDao extends BaseDao<Integer, User>{
    Optional<User> readByEmail(String email) throws DaoException;

    Optional<User> readByPhone(String phone) throws DaoException;
}
