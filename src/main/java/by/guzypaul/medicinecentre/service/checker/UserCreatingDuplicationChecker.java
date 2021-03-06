package by.guzypaul.medicinecentre.service.checker;

import by.guzypaul.medicinecentre.dao.DaoException;
import by.guzypaul.medicinecentre.dao.DaoFactory;
import by.guzypaul.medicinecentre.dao.UserDao;
import by.guzypaul.medicinecentre.entity.User;

/**
 * The type Duplication checker.
 * @author Guziy Paul
 */
public class UserCreatingDuplicationChecker {
    private final UserDao userDao;

    /**
     * Instantiates a new Duplication checker.
     */
    public UserCreatingDuplicationChecker() {
        userDao = DaoFactory.getInstance().getUserDao();
    }

    /**
     * Check duplication boolean.
     *
     * @param user the user
     * @return the boolean
     * @throws DaoException the dao exception
     */
    public boolean checkDuplication(User user) throws DaoException {
        return !userDao.readByEmail(user.getEmail()).isPresent()
                && !userDao.readByPhone(user.getPhone()).isPresent();
    }
}
