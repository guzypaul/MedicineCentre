package by.guzypaul.medicinesentre.service.validator;

import by.guzypaul.medicinecentre.entity.Doctor;
import by.guzypaul.medicinecentre.entity.Qualification;
import by.guzypaul.medicinecentre.service.checker.FileFormatChecker;
import by.guzypaul.medicinecentre.service.validator.DoctorValidator;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DoctorValidatorTest {
    private DoctorValidator doctorValidator;
    private Doctor testDoctor;
    private FileFormatChecker formatChecker;

    @BeforeEach
    void setUp() {
        doctorValidator = new DoctorValidator();
        formatChecker = mock(FileFormatChecker.class);
        testDoctor = new Doctor(1,Qualification.SURGEON, "high", "default.jpg");
    }

    @Test
    void validateRightProcedureTest() {
        when(formatChecker.checkImgFormat("default.jpg")).thenReturn(true);
        Assert.assertTrue(doctorValidator.validateDoctorForUpdating(testDoctor));
    }

    @Test
    void validateNullDoctorTest() {
        Assert.assertFalse(doctorValidator.validateDoctorForUpdating(null));
    }

    @Test
    void validateDoctorWithInvalidRankTest() {
        testDoctor.setRank("F");
        Assert.assertFalse(doctorValidator.validateDoctorForUpdating(testDoctor));
    }

    @Test
    void validateDoctorWithNullRankTest() {
        testDoctor.setRank(null);
        Assert.assertFalse(doctorValidator.validateDoctorForUpdating(testDoctor));
    }

    @Test
    void validateDoctorWithInvalidPhotoNameTest() {
        testDoctor.setPhotoName("fd");
        Assert.assertFalse(doctorValidator.validateDoctorForUpdating(testDoctor));
    }

    @Test
    void validateDoctorWithNullPhotoNameTest() {
        testDoctor.setPhotoName(null);
        Assert.assertFalse(doctorValidator.validateDoctorForUpdating(testDoctor));
    }
}
