package by.guzypaul.medicinecentre.service.impl;

import by.guzypaul.medicinecentre.dao.DaoException;
import by.guzypaul.medicinecentre.dao.DaoFactory;
import by.guzypaul.medicinecentre.dao.interfaces.UserDao;
import by.guzypaul.medicinecentre.entity.User;
import by.guzypaul.medicinecentre.service.exception.ServiceException;
import by.guzypaul.medicinecentre.service.interfaces.UserService;
import by.guzypaul.medicinecentre.service.validator.DuplicationChecker;
import by.guzypaul.medicinecentre.service.validator.UserValidator;
import org.mindrot.jbcrypt.BCrypt;

import java.util.List;
import java.util.Optional;

/**
 * The type User service.
 * @author Guziy Paul
 * @see UserService
 */
public class UserServiceImpl implements UserService {
    private static final String INVALID_USER = "Invalid user!";
    private final UserDao userDao;
    private final UserValidator userValidator;
    private final DuplicationChecker duplicationChecker;

    /**
     * Instantiates a new User service.
     */
    public UserServiceImpl() {
        userDao = DaoFactory.getInstance().getUserDao();
        userValidator = new UserValidator();
        duplicationChecker = new DuplicationChecker();
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
            if (userValidator.validateUser(entity)
                    && duplicationChecker.checkDuplication(entity)) {
                entity.setPassword(BCrypt.hashpw(entity.getPassword(), BCrypt.gensalt()));
                return userDao.create(entity);
            }

            return false;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean update(User entity) throws ServiceException {
        try {
            if (userValidator.validateUserForUpdating(entity)) {
                return userDao.update(entity);
            }
            throw new ServiceException(INVALID_USER);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
