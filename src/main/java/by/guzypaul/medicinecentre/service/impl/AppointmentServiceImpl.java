package by.guzypaul.medicinecentre.service.impl;

import by.guzypaul.medicinecentre.dao.DaoException;
import by.guzypaul.medicinecentre.dao.DaoFactory;
import by.guzypaul.medicinecentre.dao.interfaces.AppointmentDao;
import by.guzypaul.medicinecentre.entity.Appointment;
import by.guzypaul.medicinecentre.service.exception.ServiceException;
import by.guzypaul.medicinecentre.service.interfaces.AppointmentService;
import by.guzypaul.medicinecentre.validator.AppointmentValidator;

import java.util.List;

public class AppointmentServiceImpl implements AppointmentService {
    private static final String INVALID_APPOINTMENT = "Invalid appointment!";
    private final AppointmentDao appointmentDao;
    private final AppointmentValidator appointmentValidator;

    public AppointmentServiceImpl() {
        appointmentDao = DaoFactory.getInstance().getAppointmentDao();
        appointmentValidator = new AppointmentValidator();
    }

    @Override
    public List<Appointment> readAll() throws ServiceException {
        try {
            return appointmentDao.readAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Appointment readById(String id) throws ServiceException {
        try {
            return appointmentDao.readById(Integer.parseInt(id));
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean deleteById(String id) throws ServiceException {
        try {
            return appointmentDao.deleteById(Integer.parseInt(id));
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean create(Appointment entity) throws ServiceException {
        try {
            if (appointmentValidator.validateAppointment(entity)) {
                return appointmentDao.create(entity);
            }
            throw new ServiceException(INVALID_APPOINTMENT);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean update(Appointment entity) throws ServiceException {
        try {
            if (appointmentValidator.validateAppointment(entity)) {
                return appointmentDao.update(entity);
            }
            throw new ServiceException(INVALID_APPOINTMENT);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
