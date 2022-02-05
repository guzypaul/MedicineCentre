package by.guzypaul.medicinecentre.service.impl;

import by.guzypaul.medicinecentre.dao.DaoException;
import by.guzypaul.medicinecentre.dao.DaoFactory;
import by.guzypaul.medicinecentre.dao.DoctorDao;
import by.guzypaul.medicinecentre.entity.Doctor;
import by.guzypaul.medicinecentre.entity.User;
import by.guzypaul.medicinecentre.service.exception.ServiceException;
import by.guzypaul.medicinecentre.service.DoctorService;
import by.guzypaul.medicinecentre.service.validator.DoctorValidator;

import java.util.List;
import java.util.Optional;

/**
 * The type Doctor service.
 *
 * @author Guziy Paul
 * @see DoctorService
 */
public class DoctorServiceImpl implements DoctorService {
    private static final String INVALID_DOCTOR = "Invalid doctor!";
    private DoctorDao doctorDao;
    private DoctorValidator doctorValidator;


    /**
     * Instantiates a new Doctor service.
     */
    public DoctorServiceImpl() {
        doctorDao = DaoFactory.getInstance().getDoctorDao();
        doctorValidator = new DoctorValidator();
    }

    /**
     * Sets doctor dao.
     *
     * @param doctorDao the doctor dao
     */
    public void setDoctorDao(DoctorDao doctorDao) {
        this.doctorDao = doctorDao;
    }

    /**
     * Sets doctor validator.
     *
     * @param doctorValidator the doctor validator
     */
    public void setDoctorValidator(DoctorValidator doctorValidator) {
        this.doctorValidator = doctorValidator;
    }

    @Override
    public List<Doctor> readAll() throws ServiceException {
        try {
            return doctorDao.readAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Doctor> readByQualification(String qualification) throws ServiceException {
        try {
            return doctorDao.readByQualification(qualification);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<Doctor> readById(String id) throws ServiceException {
        try {
            return doctorDao.readById(Integer.parseInt(id));
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<Doctor> readByUserId(String id) throws ServiceException {
        try {
            return doctorDao.readByUserId(Integer.parseInt(id));
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean deleteById(String id) throws ServiceException {
        try {
            return doctorDao.deleteById(Integer.parseInt(id));
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteDoctorWithScheduleAndChangeUserRole(String doctorId, String scheduleId, User user) throws ServiceException {
        try {
            doctorDao.deleteDoctorWithScheduleAndChangeUserRole(Integer.parseInt(doctorId), Integer.parseInt(scheduleId), user);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean create(Doctor entity) throws ServiceException {
        try {
            if(doctorValidator.validateDoctor(entity)) {
                return doctorDao.create(entity);
            }
            throw new ServiceException(INVALID_DOCTOR);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean update(Doctor entity) throws ServiceException {
        try {
            if(doctorValidator.validateDoctorForUpdating(entity)) {
                return doctorDao.update(entity);
            }
            throw new ServiceException(INVALID_DOCTOR);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
