package by.guzypaul.medicinecentre.service.impl;

import by.guzypaul.medicinecentre.dao.DaoException;
import by.guzypaul.medicinecentre.dao.DaoFactory;
import by.guzypaul.medicinecentre.dao.interfaces.DoctorScheduleDao;
import by.guzypaul.medicinecentre.entity.DoctorSchedule;
import by.guzypaul.medicinecentre.service.exception.ServiceException;
import by.guzypaul.medicinecentre.service.interfaces.DoctorScheduleService;
import by.guzypaul.medicinecentre.validator.DoctorScheduleValidator;

import java.util.List;

public class DoctorScheduleServiceImpl implements DoctorScheduleService {
    private static final String INVALID_DOCTOR_SCHEDULE = "Invalid doctor schedule!";
    private final DoctorScheduleDao doctorScheduleDao;
    private final DoctorScheduleValidator doctorScheduleValidator;

    public DoctorScheduleServiceImpl() {
        doctorScheduleDao = DaoFactory.getInstance().getDoctorScheduleDao();
        doctorScheduleValidator = new DoctorScheduleValidator();
    }

    @Override
    public List<DoctorSchedule> readAll() throws ServiceException {
        try {
            return doctorScheduleDao.readAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public DoctorSchedule readById(String id) throws ServiceException {
        try {
            return doctorScheduleDao.readById(Integer.parseInt(id));
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean deleteById(String id) throws ServiceException {
        try {
            return doctorScheduleDao.deleteById(Integer.parseInt(id));
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean create(DoctorSchedule entity) throws ServiceException {
        try {
            if (doctorScheduleValidator.validateDoctorSchedule(entity)) {
                return doctorScheduleDao.create(entity);
            }
            throw new ServiceException(INVALID_DOCTOR_SCHEDULE);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean update(DoctorSchedule entity) throws ServiceException {
        try {
            if (doctorScheduleValidator.validateDoctorSchedule(entity)) {
                return doctorScheduleDao.update(entity);
            }
            throw new ServiceException(INVALID_DOCTOR_SCHEDULE);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
