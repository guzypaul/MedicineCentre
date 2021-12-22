package by.guzypaul.medicinecentre.service.impl;

import by.guzypaul.medicinecentre.dao.DaoException;
import by.guzypaul.medicinecentre.dao.impl.ProcedureDaoImpl;
import by.guzypaul.medicinecentre.dao.interfaces.AppointmentDao;
import by.guzypaul.medicinecentre.entity.Appointment;
import by.guzypaul.medicinecentre.service.exception.ServiceException;
import by.guzypaul.medicinecentre.service.interfaces.AppointmentService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class AppointmentServiceImpl implements AppointmentService {
    private static final Logger logger = LogManager.getLogger();
    private final AppointmentDao appointmentDao;

    public AppointmentServiceImpl(AppointmentDao appointmentDao, ProcedureDaoImpl procedureDao) {
        this.appointmentDao = appointmentDao;
    }

    @Override
    public List<Appointment> readAll() throws ServiceException {
        logger.log(Level.DEBUG, "readAll");
        try {
            List<Appointment> appointments;
            appointments = appointmentDao.readAll();
            return appointments;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Appointment readById(String id) throws ServiceException {
        logger.log(Level.DEBUG, "readById(), Appointment id:" + id);
        try {
            Appointment appointment;
            appointment = appointmentDao.readById(Integer.parseInt(id));
            return appointment;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean deleteById(String id) throws ServiceException {
        logger.log(Level.DEBUG, "delete Appointment id:" + id);
        try {
            return appointmentDao.deleteById(Integer.parseInt(id));
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean create(Appointment entity) throws ServiceException {
        logger.log(Level.DEBUG, "create " + entity);
        try {
            return appointmentDao.create(entity);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean update(Appointment entity) throws ServiceException {
        logger.log(Level.DEBUG, "update " + entity);
        try {
            return appointmentDao.update(entity);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
