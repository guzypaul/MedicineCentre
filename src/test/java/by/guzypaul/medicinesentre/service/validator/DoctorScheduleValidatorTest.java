package by.guzypaul.medicinesentre.service.validator;

import by.guzypaul.medicinecentre.entity.DoctorSchedule;
import by.guzypaul.medicinecentre.service.validator.DoctorScheduleValidator;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Time;

public class DoctorScheduleValidatorTest {
    private DoctorScheduleValidator doctorScheduleValidator;
    private DoctorSchedule testDoctorSchedule;

    @BeforeEach
    void setUp() {
        doctorScheduleValidator = new DoctorScheduleValidator();
        testDoctorSchedule = new DoctorSchedule(1, Time.valueOf("09:00:00"), Time.valueOf("20:00:00"), "all week");
    }

    @Test
    void validateNullDoctorScheduleTest() {
        Assert.assertFalse(doctorScheduleValidator.validateDoctorScheduleForUpdating(null));
    }

    @Test
    void validateDoctorScheduleWithInvalidStartTimeTest() {
        testDoctorSchedule.setStartTime(Time.valueOf("07:00:00"));
        Assert.assertFalse(doctorScheduleValidator.validateDoctorScheduleForUpdating(testDoctorSchedule));
    }

    @Test
    void validateDoctorScheduleWithNullStartTimeTest() {
        testDoctorSchedule.setStartTime(null);
        Assert.assertFalse(doctorScheduleValidator.validateDoctorScheduleForUpdating(testDoctorSchedule));
    }

    @Test
    void validateDoctorScheduleWithInvalidEndTimeTest() {
        testDoctorSchedule.setEndTime(Time.valueOf("23:00:00"));
        Assert.assertFalse(doctorScheduleValidator.validateDoctorScheduleForUpdating(testDoctorSchedule));
    }

    @Test
    void validateDoctorScheduleWithNullEndTimeTest() {
        testDoctorSchedule.setEndTime(null);
        Assert.assertFalse(doctorScheduleValidator.validateDoctorScheduleForUpdating(testDoctorSchedule));
    }
}
