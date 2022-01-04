package by.guzypaul.medicinecentre.validator;

import by.guzypaul.medicinecentre.dao.DaoException;
import by.guzypaul.medicinecentre.dao.DaoFactory;
import by.guzypaul.medicinecentre.dao.interfaces.UserDao;
import by.guzypaul.medicinecentre.entity.User;

public class DuplicationChecker {
    private final UserDao userDao;

    public DuplicationChecker() {
        userDao = DaoFactory.getInstance().getUserDao();
    }

    public boolean checkDuplication(User user) throws DaoException {
        return !userDao.readByEmail(user.getEmail()).isPresent()
                && !userDao.readByPhone(user.getPhone()).isPresent();
    }
}
