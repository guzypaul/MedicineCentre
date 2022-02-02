package by.guzypaul.medicinecentre.service.impl;

import by.guzypaul.medicinecentre.dao.DaoException;
import by.guzypaul.medicinecentre.dao.DaoFactory;
import by.guzypaul.medicinecentre.dao.interfaces.AppointmentDao;
import by.guzypaul.medicinecentre.entity.Appointment;
import by.guzypaul.medicinecentre.service.exception.ServiceException;
import by.guzypaul.medicinecentre.service.interfaces.AppointmentService;
import by.guzypaul.medicinecentre.validator.AppointmentValidator;

import java.util.List;
import java.util.Optional;

/**
 * The type Appointment service.
 * @author Guziy Paul
 * @see AppointmentService
 */
public class AppointmentServiceImpl implements AppointmentService {
    private static final String INVALID_APPOINTMENT = "Invalid appointment!";
    private final AppointmentDao appointmentDao;
    private final AppointmentValidator appointmentValidator;

    /**
     * Instantiates a new Appointment service.
     */
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
    public List<Appointment> readByDoctorId(String doctorId) throws ServiceException {
        try {
            return appointmentDao.readByDoctorId(Integer.parseInt(doctorId));
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Appointment> readByClientId(String clientId) throws ServiceException {
        try {
            return appointmentDao.readByClientId(Integer.parseInt(clientId));
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<Appointment> readById(String id) throws ServiceException {
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
