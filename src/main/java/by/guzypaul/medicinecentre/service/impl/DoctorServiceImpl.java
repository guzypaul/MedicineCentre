package by.guzypaul.medicinecentre.service.impl;

import by.guzypaul.medicinecentre.dao.DaoException;
import by.guzypaul.medicinecentre.dao.interfaces.DoctorDao;
import by.guzypaul.medicinecentre.entity.Doctor;
import by.guzypaul.medicinecentre.service.exception.ServiceException;
import by.guzypaul.medicinecentre.service.interfaces.DoctorService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class DoctorServiceImpl implements DoctorService {
    private static final Logger logger = LogManager.getLogger();
    private final DoctorDao doctorDao;

    public DoctorServiceImpl(DoctorDao doctorDao) {
        this.doctorDao = doctorDao;
    }

    @Override
    public List<Doctor> readAll() throws ServiceException {
        logger.log(Level.DEBUG, "readAll");
        try {
            List<Doctor> doctors;
            doctors = doctorDao.readAll();
            return doctors;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Doctor readById(String id) throws ServiceException {
        logger.log(Level.DEBUG, "readById(), Doctor id:" + id);
        try {
            Doctor doctor;
            doctor = doctorDao.readById(Integer.parseInt(id));
            return doctor;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean deleteById(String id) throws ServiceException {
        logger.log(Level.DEBUG, "delete Doctor id:" + id);
        try {
            return doctorDao.deleteById(Integer.parseInt(id));
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean create(Doctor entity) throws ServiceException {
        logger.log(Level.DEBUG, "create " + entity);
        try {
            return doctorDao.create(entity);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean update(Doctor entity) throws ServiceException {
        logger.log(Level.DEBUG, "update " + entity);
        try {
            return doctorDao.update(entity);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
