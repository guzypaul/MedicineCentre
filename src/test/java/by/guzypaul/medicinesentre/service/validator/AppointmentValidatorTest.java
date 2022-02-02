package by.guzypaul.medicinesentre.service.validator;

import by.guzypaul.medicinecentre.entity.*;
import by.guzypaul.medicinecentre.service.validator.AppointmentValidator;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalDate;

import static org.mockito.Mockito.mock;

public class AppointmentValidatorTest {
    private AppointmentValidator appointmentValidator;
    private AppointmentValidator appointmentValidator2;
    private Appointment testAppointment;

    @BeforeEach
    void setUp() {
        appointmentValidator2 = mock(AppointmentValidator.class);
        appointmentValidator = new AppointmentValidator(); //todo mockito
        User userClient = new User(1, "Ivan", "Petrov", "ivan_petrov@gmail.com",
                "12345678", "375257897878", Role.USER);
        Doctor doctor = new Doctor(1, "surgeon", "high", "default.jpg");
        Procedure procedure = new Procedure(1, "surgery", "default1.jpg", BigDecimal.valueOf(500),
                "removing something extra ", 30, "surgeon");
        testAppointment = new Appointment(userClient, doctor, LocalDate.now().plusDays(10),
                Time.valueOf("11:00:00"), Time.valueOf("12:00:00"), procedure, "CLAIMED");
    }

    @Test
    void validateNullAppointmentTest() {
        Assert.assertFalse(appointmentValidator.validateAppointment(null));
    }

    @Test
    void validateAppointmentWithNullDateTest() {
        testAppointment.setDate(null);
        Assert.assertFalse(appointmentValidator.validateAppointment(testAppointment));
    }

    @Test
    void validateAppointmentWithInvalidStartTimeTest() {
        testAppointment.setStartTime(Time.valueOf("07:00:00"));
        Assert.assertFalse(appointmentValidator.validateAppointment(testAppointment));
    }

    @Test
    void validateAppointmentWithNullStartTimeTest() {
        testAppointment.setStartTime(null);
        Assert.assertFalse(appointmentValidator.validateAppointment(testAppointment));
    }

    @Test
    void validateAppointmentWithInvalidStatusTest() {
        testAppointment.setStatus("Canceledddd");
        Assert.assertFalse(appointmentValidator.validateAppointment(testAppointment));
    }

    @Test
    void validateAppointmentWithNullStatusTest() {
        testAppointment.setEndTime(null);
        Assert.assertFalse(appointmentValidator.validateAppointment(testAppointment));
    }

    @Test
    void validateDoctorScheduleWithInvalidEndTimeTest() {
        testAppointment.setEndTime(Time.valueOf("23:00:00"));
        Assert.assertFalse(appointmentValidator.validateAppointment(testAppointment));
    }

    @Test
    void validateDoctorScheduleWithNullEndTimeTest() {
        testAppointment.setEndTime(null);
        Assert.assertFalse(appointmentValidator.validateAppointment(testAppointment));
    }
}
