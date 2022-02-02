package by.guzypaul.medicinecentre.dao.interfaces;

import by.guzypaul.medicinecentre.dao.DaoException;
import by.guzypaul.medicinecentre.entity.User;

import java.sql.PreparedStatement;
import java.util.Optional;

/**
 * The interface User dao.
 * @author Guziy Paul
 * @see BaseDao
 */
public interface UserDao extends BaseDao<Integer, User>{
    /**
     * Read by email optional.
     *
     * @param email the email
     * @return the optional
     * @throws DaoException the dao exception
     */
    Optional<User> readByEmail(String email) throws DaoException;

    /**
     * Read by phone optional.
     *
     * @param phone the phone
     * @return the optional
     * @throws DaoException the dao exception
     */
    Optional<User> readByPhone(String phone) throws DaoException;

    /**
     * Fill data for user update prepared statement.
     *
     * @param preparedStatement the prepared statement
     * @param entity            the entity
     * @return the prepared statement
     * @throws DaoException the dao exception
     */
    PreparedStatement fillDataForUserUpdate(PreparedStatement preparedStatement, User entity) throws DaoException;
}
