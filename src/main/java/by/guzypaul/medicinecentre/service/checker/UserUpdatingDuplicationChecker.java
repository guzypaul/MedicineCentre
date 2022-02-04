package by.guzypaul.medicinecentre.service.checker;

import by.guzypaul.medicinecentre.dao.DaoException;
import by.guzypaul.medicinecentre.dao.DaoFactory;
import by.guzypaul.medicinecentre.dao.UserDao;
import by.guzypaul.medicinecentre.entity.User;

import java.util.Optional;

public class UserUpdatingDuplicationChecker {
    private final UserDao userDao;

    public UserUpdatingDuplicationChecker() {
        userDao = DaoFactory.getInstance().getUserDao();
    }

    public boolean checkDuplication(User user) throws DaoException {
        return checkEmailDuplication(user) && checkPhoneNumberDuplication(user);
    }

    private boolean checkEmailDuplication(User user) throws DaoException {
        Optional<User> optionalUser = userDao.readByEmail(user.getEmail());
        return !optionalUser.isPresent() || optionalUser.get().getId() == user.getId();
    }

    private boolean checkPhoneNumberDuplication(User user) throws DaoException {
        Optional<User> optionalUser = userDao.readByPhone(user.getPhone());
        return !optionalUser.isPresent() || optionalUser.get().getId() == user.getId();
    }
}
