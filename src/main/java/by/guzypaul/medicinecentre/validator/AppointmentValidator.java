package by.guzypaul.medicinecentre.validator;

import by.guzypaul.medicinecentre.entity.Appointment;

import java.sql.Time;
import java.time.LocalDate;

public class AppointmentValidator {
    private static final LocalDate MAX_DATE = LocalDate.now().plusMonths(12);
    private static final LocalDate MIN_DATE = LocalDate.now();
    private static final Time START_TIME = Time.valueOf("08:00:00");
    private static final Time END_TIME = Time.valueOf("22:00:00");
    private final UserValidator userValidator = new UserValidator();
    private final DoctorValidator doctorValidator = new DoctorValidator();
    private final ProcedureValidator procedureValidator = new ProcedureValidator();

    public boolean validateAppointment(Appointment appointment) {
        return appointment != null && userValidator.validateUser(appointment.getUserClient())
                && doctorValidator.validateDoctor(appointment.getDoctor())
                && procedureValidator.validateProcedure(appointment.getProcedure())
                && isValidDate(appointment.getDate())
                && isValidStartTime(appointment.getStartTime())
                && isValidEndTime(appointment.getEndTime())
                && isValidStatus(appointment.getStatus());
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
        return text != null && !text.isEmpty() && text.length() < 30;
    }
}
