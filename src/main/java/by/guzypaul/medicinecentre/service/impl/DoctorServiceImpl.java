package by.guzypaul.medicinecentre.service.impl;

import by.guzypaul.medicinecentre.dao.DaoException;
import by.guzypaul.medicinecentre.dao.DaoFactory;
import by.guzypaul.medicinecentre.dao.interfaces.DoctorDao;
import by.guzypaul.medicinecentre.entity.Doctor;
import by.guzypaul.medicinecentre.service.exception.ServiceException;
import by.guzypaul.medicinecentre.service.interfaces.DoctorService;
import by.guzypaul.medicinecentre.validator.DoctorValidator;

import java.util.List;
import java.util.Optional;

public class DoctorServiceImpl implements DoctorService {
    private static final String INVALID_DOCTOR = "Invalid doctor!";
    private final DoctorDao doctorDao;
    private final DoctorValidator doctorValidator;


    public DoctorServiceImpl() {
        doctorDao = DaoFactory.getInstance().getDoctorDao();
        doctorValidator = new DoctorValidator();
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
    public Optional<Doctor> readById(String id) throws ServiceException {
        try {
            return doctorDao.readById(Integer.parseInt(id));
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
            if(doctorValidator.validateDoctor(entity)) {
                return doctorDao.update(entity);
            }
            throw new ServiceException(INVALID_DOCTOR);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
