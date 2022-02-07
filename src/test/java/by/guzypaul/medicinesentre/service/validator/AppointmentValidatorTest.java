package by.guzypaul.medicinesentre.service.validator;

import by.guzypaul.medicinecentre.entity.*;
import by.guzypaul.medicinecentre.service.validator.AppointmentValidator;
import by.guzypaul.medicinecentre.service.validator.DoctorValidator;
import by.guzypaul.medicinecentre.service.validator.ProcedureValidator;
import by.guzypaul.medicinecentre.service.validator.UserValidator;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalDate;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AppointmentValidatorTest {
    private AppointmentValidator appointmentValidator;
    private Appointment testAppointment;
    private UserValidator userValidator;
    private DoctorValidator doctorValidator;
    private ProcedureValidator procedureValidator;

    @BeforeEach
    void setUp() {
        userValidator = mock(UserValidator.class);
        doctorValidator = mock(DoctorValidator.class);
        procedureValidator = mock(ProcedureValidator.class);
        appointmentValidator = new AppointmentValidator();
        appointmentValidator.setDoctorValidator(doctorValidator);
        appointmentValidator.setUserValidator(userValidator);
        appointmentValidator.setProcedureValidator(procedureValidator);
        User userClient = new User(1, "Ivan", "Petrov", "ivan_petrov@gmail.com",
                "12345678", "375257897878", Role.USER);
        Doctor doctor = new Doctor(1, Qualification.SURGEON, "high", "default.jpg");
        Procedure procedure = new Procedure(1, "surgery", "default1.jpg", BigDecimal.valueOf(500),
                "removing something extra ", 30, Qualification.SURGEON);
        testAppointment = new Appointment(userClient, doctor, LocalDate.now().plusDays(10),
                Time.valueOf("11:00:00"), Time.valueOf("12:00:00"), procedure, AppointmentStatus.CLAIMED);
        when(doctorValidator.validateDoctor(doctor)).thenReturn(true);
        when(procedureValidator.validateProcedure(procedure)).thenReturn(true);
        when(userValidator.isValidUser(userClient)).thenReturn(true);
    }

    @Test
    void validateNullAppointmentTest() {
        Assert.assertFalse(appointmentValidator.validateAppointment(null));
    }

    @Test
    void validateRightAppointmentTest() {
        Assert.assertTrue(appointmentValidator.validateAppointment(testAppointment));
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
