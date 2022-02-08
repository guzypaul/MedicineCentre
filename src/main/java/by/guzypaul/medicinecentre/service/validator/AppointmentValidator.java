package by.guzypaul.medicinecentre.service.validator;

import by.guzypaul.medicinecentre.entity.Appointment;
import by.guzypaul.medicinecentre.entity.AppointmentStatus;

import java.sql.Time;
import java.time.LocalDate;

/**
 * The type Appointment validator.
 * @author Guziy Paul
 */
public class AppointmentValidator {
    private static final LocalDate MAX_DATE = LocalDate.now().plusMonths(12);
    private static final LocalDate MIN_DATE = LocalDate.now();
    private static final Time START_TIME = Time.valueOf("08:00:00");
    private static final Time END_TIME = Time.valueOf("22:00:00");
    private UserValidator userValidator;
    private DoctorValidator doctorValidator;
    private ProcedureValidator procedureValidator;

    public AppointmentValidator() {
        userValidator = new UserValidator();
        doctorValidator = new DoctorValidator();
        procedureValidator = new ProcedureValidator();
    }

    public void setUserValidator(UserValidator userValidator) {
        this.userValidator = userValidator;
    }

    public void setDoctorValidator(DoctorValidator doctorValidator) {
        this.doctorValidator = doctorValidator;
    }

    public void setProcedureValidator(ProcedureValidator procedureValidator) {
        this.procedureValidator = procedureValidator;
    }

    /**
     * Validate appointment boolean.
     *
     * @param appointment the appointment
     * @return the boolean
     */
    public boolean isValidAppointment(Appointment appointment) {
        return appointment != null && userValidator.isValidUser(appointment.getUserClient())
                && doctorValidator.validateDoctor(appointment.getDoctor())
                && procedureValidator.validateProcedure(appointment.getProcedure())
                && isValidDate(appointment.getDate())
                && isValidStartTime(appointment.getStartTime())
                && isValidEndTime(appointment.getEndTime())
                && isValidStatus(String.valueOf(appointment.getStatus()));
    }

    private boolean isValidDate(LocalDate date) {
        return date != null && date.compareTo(MAX_DATE) < 1 && date.compareTo(MIN_DATE) > -1;
    }

    private boolean isValidStartTime(Time startTime) {
        return startTime != null && startTime.compareTo(START_TIME) > -1;
    }

    private boolean isValidEndTime(Time endTime) {
        return endTime != null && endTime.compareTo(END_TIME) < 1;
    }

    private boolean isValidStatus(String text) {
        return text != null && AppointmentStatus.isValidAppointmentStatus(text);
    }
}
