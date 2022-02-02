package by.guzypaul.medicinesentre.service.validator;

import by.guzypaul.medicinecentre.entity.Doctor;
import by.guzypaul.medicinecentre.service.validator.DoctorValidator;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DoctorValidatorTest {
    private DoctorValidator doctorValidator;
    private Doctor testDoctor;

    @BeforeEach
    void setUp() {
        doctorValidator = new DoctorValidator();
        testDoctor = new Doctor(1,"surgeon", "high", "default.jpg");
    }

    @Test
    void validateNullDoctorTest() {
        Assert.assertFalse(doctorValidator.validateDoctorForUpdating(null));
    }

    @Test
    void validateDoctorWithNullRankTest() {
        testDoctor.setRank(null);
        Assert.assertFalse(doctorValidator.validateDoctorForUpdating(testDoctor));
    }

    @Test
    void validateDoctorWithNullQualificationTest() {
        testDoctor.setQualification(null);
        Assert.assertFalse(doctorValidator.validateDoctorForUpdating(testDoctor));
    }

    @Test
    void validateDoctorWithNullPhotoNameTest() {
        testDoctor.setPhotoName(null);
        Assert.assertFalse(doctorValidator.validateDoctorForUpdating(testDoctor));
    }

    @Test
    void validateDoctorWithInvalidRankTest() {
        testDoctor.setRank("F");
        Assert.assertFalse(doctorValidator.validateDoctorForUpdating(testDoctor));
    }

    @Test
    void validateDoctorWithInvalidQualificationTest() {
        testDoctor.setQualification("fr");
        Assert.assertFalse(doctorValidator.validateDoctorForUpdating(testDoctor));
    }




}
