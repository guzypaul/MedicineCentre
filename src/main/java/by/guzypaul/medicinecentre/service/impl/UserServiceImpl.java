package by.guzypaul.medicinecentre.service.impl;

import by.guzypaul.medicinecentre.dao.DaoException;
import by.guzypaul.medicinecentre.dao.DaoFactory;
import by.guzypaul.medicinecentre.dao.UserDao;
import by.guzypaul.medicinecentre.entity.User;
import by.guzypaul.medicinecentre.service.checker.UserCreatingDuplicationChecker;
import by.guzypaul.medicinecentre.service.checker.UserUpdatingDuplicationChecker;
import by.guzypaul.medicinecentre.service.exception.ServiceException;
import by.guzypaul.medicinecentre.service.UserService;
import by.guzypaul.medicinecentre.service.validator.UserValidator;
import org.mindrot.jbcrypt.BCrypt;

import java.util.List;
import java.util.Optional;

/**
 * The type User service.
 *
 * @author Guziy Paul
 * @see UserService
 */
public class UserServiceImpl implements UserService {
    private static final String INVALID_USER = "Invalid user!";
    private static final String DUPLICATE_USER = "User with such e-mail or phone number already exist!";
    private UserDao userDao;
    private UserValidator userValidator;
    private UserCreatingDuplicationChecker userCreatingDuplicationChecker;
    private UserUpdatingDuplicationChecker userUpdatingDuplicationChecker;

    /**
     * Instantiates a new User service.
     */
    public UserServiceImpl() {
        userDao = DaoFactory.getInstance().getUserDao();
        userValidator = new UserValidator();
        userCreatingDuplicationChecker = new UserCreatingDuplicationChecker();
        userUpdatingDuplicationChecker = new UserUpdatingDuplicationChecker();
    }

    /**
     * Sets user dao.
     *
     * @param userDao the user dao
     */
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * Sets user validator.
     *
     * @param userValidator the user validator
     */
    public void setUserValidator(UserValidator userValidator) {
        this.userValidator = userValidator;
    }

    /**
     * Sets user creating duplication checker.
     *
     * @param userCreatingDuplicationChecker the user creating duplication checker
     */
    public void setUserCreatingDuplicationChecker(UserCreatingDuplicationChecker userCreatingDuplicationChecker) {
        this.userCreatingDuplicationChecker = userCreatingDuplicationChecker;
    }

    /**
     * Sets user updating duplication checker.
     *
     * @param userUpdatingDuplicationChecker the user updating duplication checker
     */
    public void setUserUpdatingDuplicationChecker(UserUpdatingDuplicationChecker userUpdatingDuplicationChecker) {
        this.userUpdatingDuplicationChecker = userUpdatingDuplicationChecker;
    }

    @Override
    public List<User> readAll() throws ServiceException {
        try {
            return userDao.readAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<User> readById(String id) throws ServiceException {
        try {
            return userDao.readById(Integer.parseInt(id));
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<User> readByEmail(String email) throws ServiceException {
        try {
            return userDao.readByEmail(email);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<User> readByPhone(String phone) throws ServiceException {
        try {
            return userDao.readByPhone(phone);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean deleteById(String id) throws ServiceException {
        try {
            return userDao.deleteById(Integer.parseInt(id));
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean create(User entity) throws ServiceException {
        try {
            if (!userValidator.validateUser(entity) ) {
                throw new ServiceException(INVALID_USER);
            }

            if (!userCreatingDuplicationChecker.checkDuplication(entity)) {
                throw new ServiceException(DUPLICATE_USER);
            }

            entity.setPassword(BCrypt.hashpw(entity.getPassword(), BCrypt.gensalt()));
            return userDao.create(entity);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean update(User entity) throws ServiceException {
        try {
            if (!userValidator.validateUserForUpdating(entity)) {
                throw new ServiceException(INVALID_USER);
            }

            if (!userUpdatingDuplicationChecker.checkDuplication(entity)) {
                throw new ServiceException(DUPLICATE_USER);
            }

            return userDao.update(entity);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
