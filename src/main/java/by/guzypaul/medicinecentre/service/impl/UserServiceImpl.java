package by.guzypaul.medicinecentre.service.impl;

import by.guzypaul.medicinecentre.dao.DaoException;
import by.guzypaul.medicinecentre.dao.interfaces.UserDao;
import by.guzypaul.medicinecentre.entity.User;
import by.guzypaul.medicinecentre.service.exception.ServiceException;
import by.guzypaul.medicinecentre.service.interfaces.UserService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class UserServiceImpl implements UserService {
    private static final Logger logger = LogManager.getLogger();
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> readAll() throws ServiceException {
        logger.log(Level.DEBUG, "readAll");
        try {
            List<User> users;
            users = userDao.readAll();
            return users;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public User readById(Integer id) throws ServiceException {
        logger.log(Level.DEBUG, "readById(), User id:" + id);
        try {
            User user;
            user = userDao.readById(id);
            return user;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean deleteById(Integer id) throws ServiceException {
        logger.log(Level.DEBUG, "delete User id:" + id);
        try {
            return userDao.deleteById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean create(User entity) throws ServiceException {
        logger.log(Level.DEBUG, "create " + entity);
        try {
            return userDao.create(entity);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean update(User entity) throws ServiceException {
        logger.log(Level.DEBUG, "update " + entity);
        try {
            return userDao.update(entity);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
