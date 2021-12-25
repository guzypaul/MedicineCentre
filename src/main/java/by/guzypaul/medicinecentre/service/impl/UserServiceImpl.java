package by.guzypaul.medicinecentre.service.impl;

import by.guzypaul.medicinecentre.dao.DaoException;
import by.guzypaul.medicinecentre.dao.DaoFactory;
import by.guzypaul.medicinecentre.dao.interfaces.UserDao;
import by.guzypaul.medicinecentre.entity.User;
import by.guzypaul.medicinecentre.service.exception.ServiceException;
import by.guzypaul.medicinecentre.service.interfaces.UserService;
import by.guzypaul.medicinecentre.validator.UserValidator;
import org.mindrot.jbcrypt.BCrypt;

import java.util.List;

public class UserServiceImpl implements UserService {
    private static final String INVALID_USER = "Invalid user!";
    private final UserDao userDao;
    private final UserValidator userValidator;

    public UserServiceImpl() {
        userDao = DaoFactory.getInstance().getUserDao();
        userValidator = new UserValidator();
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
    public User readById(String id) throws ServiceException {
        try {
            return userDao.readById(Integer.parseInt(id));
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
            if (userValidator.validateUser(entity)) {
                entity.setPassword(BCrypt.hashpw(entity.getPassword(), BCrypt.gensalt()));
                return userDao.create(entity);
            }
            throw new ServiceException(INVALID_USER);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean update(User entity) throws ServiceException {
        try {
            if (userValidator.validateUser(entity)) {
                return userDao.update(entity);
            }
            throw new ServiceException(INVALID_USER);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
