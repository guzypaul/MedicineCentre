package by.guzypaul.medicinesentre.service.impl;

import by.guzypaul.medicinecentre.dao.DaoException;
import by.guzypaul.medicinecentre.dao.DoctorDao;
import by.guzypaul.medicinecentre.entity.Doctor;
import by.guzypaul.medicinecentre.entity.Qualification;
import by.guzypaul.medicinecentre.entity.Role;
import by.guzypaul.medicinecentre.entity.User;
import by.guzypaul.medicinecentre.service.exception.ServiceException;
import by.guzypaul.medicinecentre.service.impl.DoctorServiceImpl;
import by.guzypaul.medicinecentre.service.validator.DoctorValidator;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DoctorServiceImplTest {
    private DoctorServiceImpl doctorService;
    private DoctorDao doctorDao;
    private Doctor firstTestDoctor;
    private Doctor secondTestDoctor;
    private DoctorValidator doctorValidator;

    @BeforeEach
    void setUp() {
        doctorService = new DoctorServiceImpl();
        doctorDao = mock(DoctorDao.class);
        doctorValidator = mock(DoctorValidator.class);
        doctorService.setDoctorDao(doctorDao);
        doctorService.setDoctorValidator(doctorValidator);

        User user1 = new User(1, "Ivan", "Petrov", "ivan_petrov@gmail.com",
                "12345678", "375257897878", Role.DOCTOR);
        User user2 = new User(2, "Ivan", "Fedorov", "ivan_fedorov@gmail.com",
                "12345678", "375257897848", Role.DOCTOR);
        firstTestDoctor = new Doctor(1, Qualification.DENTIST, "high", user1, "doctor1.jpg");
        secondTestDoctor = new Doctor(2, Qualification.SURGEON, "low", user2, "doctor2.jpg");
    }

    @Test
    void readAllDoctorsTest() throws DaoException, ServiceException {
        List<Doctor> doctorList = Arrays.asList(firstTestDoctor, secondTestDoctor);
        when(doctorDao.readAll()).thenReturn(doctorList);
        Assert.assertEquals(doctorList, doctorService.readAll());
    }

    @Test
    void readDoctorsByIdTest() throws DaoException, ServiceException {
        when(doctorDao.readById(1)).thenReturn(Optional.of(firstTestDoctor));
        Assert.assertEquals(firstTestDoctor, doctorService.readById("1").get());
    }

    @Test
    void readDoctorWithInvalidIdTest() {
        Assert.assertThrows(NumberFormatException.class, () -> doctorService.readById("egeg"));
    }

    @Test
    void addDoctorTest() throws DaoException, ServiceException {
        when(doctorDao.create(firstTestDoctor)).thenReturn(true);
        when(doctorValidator.validateDoctor(firstTestDoctor)).thenReturn(true);
        Assert.assertTrue(doctorService.create(firstTestDoctor));
    }

    @Test
    void deleteDoctorByIdTest() throws DaoException, ServiceException {
        when(doctorDao.deleteById(1)).thenReturn(true);
        Assert.assertTrue(doctorService.deleteById("1"));
    }

    @Test
    void deleteDoctorWithInvalidIdTest() {
        Assert.assertThrows(NumberFormatException.class, () -> doctorService.deleteById("dada"));
    }

    @Test
    void updateDoctorTest() throws DaoException, ServiceException {
        when(doctorValidator.validateDoctorForUpdating(firstTestDoctor)).thenReturn(true);
        when(doctorDao.update(firstTestDoctor)).thenReturn(true);
        Assert.assertTrue(doctorService.update(firstTestDoctor));
    }

    @Test
    void readDoctorByQualificationTest() throws DaoException, ServiceException {
        List<Doctor> doctorList = Arrays.asList(secondTestDoctor);
        when(doctorDao.readByQualification(Qualification.SURGEON.toString())).thenReturn(doctorList);
        Assert.assertEquals(doctorList, doctorService.readByQualification(Qualification.SURGEON.toString()));
    }

    @Test
    void readDoctorByUserIdTest() throws DaoException, ServiceException {
        when(doctorDao.readByUserId(1)).thenReturn(Optional.of(firstTestDoctor));
        Assert.assertEquals(Optional.of(firstTestDoctor), doctorService.readByUserId("1"));
    }
}
