package by.guzypaul.medicinecentre.service.impl;

import by.guzypaul.medicinecentre.dao.DaoException;
import by.guzypaul.medicinecentre.dao.interfaces.DoctorScheduleDao;
import by.guzypaul.medicinecentre.entity.DoctorSchedule;
import by.guzypaul.medicinecentre.service.exception.ServiceException;
import by.guzypaul.medicinecentre.service.interfaces.DoctorScheduleService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class DoctorScheduleServiceImpl implements DoctorScheduleService {
    private static final Logger logger = LogManager.getLogger();
    private final DoctorScheduleDao doctorScheduleDao;

    public DoctorScheduleServiceImpl(DoctorScheduleDao doctorScheduleDao) {
        this.doctorScheduleDao = doctorScheduleDao;
    }

    @Override
    public List<DoctorSchedule> readAll() throws ServiceException {
        logger.log(Level.DEBUG, "readAll");
        try {
            List<DoctorSchedule> doctorSchedules;
            doctorSchedules = doctorScheduleDao.readAll();
            return doctorSchedules;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public DoctorSchedule readById(Integer id) throws ServiceException {
        logger.log(Level.DEBUG, "readById(), DoctorSchedule id:" + id);
        try {
            DoctorSchedule doctorSchedule;
            doctorSchedule = doctorScheduleDao.readById(id);
            return doctorSchedule;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean deleteById(Integer id) throws ServiceException {
        logger.log(Level.DEBUG, "delete DoctorSchedule id:" + id);
        try {
            return doctorScheduleDao.deleteById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean create(DoctorSchedule entity) throws ServiceException {
        logger.log(Level.DEBUG, "create " + entity);
        try {
            return doctorScheduleDao.create(entity);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean update(DoctorSchedule entity) throws ServiceException {
        logger.log(Level.DEBUG, "update " + entity);
        try {
            return doctorScheduleDao.update(entity);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
