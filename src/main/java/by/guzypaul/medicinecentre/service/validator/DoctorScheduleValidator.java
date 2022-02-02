package by.guzypaul.medicinecentre.service.validator;

import by.guzypaul.medicinecentre.entity.DoctorSchedule;

import java.sql.Time;

/**
 * The type Doctor schedule validator.
 * @author Guziy Paul
 */
public class DoctorScheduleValidator {
    private static final String INFO = "([\\p{Alpha}А-Яа-я]{1,30}[\\s-]?){0,9}";
    private static final Time START_TIME = Time.valueOf("08:00:00");
    private static final Time END_TIME = Time.valueOf("22:00:00");
    private final DoctorValidator doctorValidator = new DoctorValidator();

    /**
     * Validate doctor schedule boolean.
     *
     * @param doctorSchedule the doctor schedule
     * @return the boolean
     */
    public boolean validateDoctorSchedule(DoctorSchedule doctorSchedule) {
        return doctorSchedule != null && doctorValidator.validateDoctor(doctorSchedule.getDoctor())
                && isValidStartTime(doctorSchedule.getStartTime())
                && isValidEndTime(doctorSchedule.getEndTime())
                && isValidInfo(doctorSchedule.getInfo());
    }

    /**
     * Validate doctor schedule for updating boolean.
     *
     * @param doctorSchedule the doctor schedule
     * @return the boolean
     */
    public boolean validateDoctorScheduleForUpdating(DoctorSchedule doctorSchedule) {
        return doctorSchedule != null && isValidStartTime(doctorSchedule.getStartTime())
                && isValidEndTime(doctorSchedule.getEndTime())
                && isValidInfo(doctorSchedule.getInfo());
    }

    private boolean isValidInfo(String text) {
        return text != null && text.matches(INFO);
    }

    private boolean isValidStartTime(Time startTime) {
        return startTime != null && startTime.compareTo(START_TIME) > -1;
    }

    private boolean isValidEndTime(Time endTime) {
        return endTime != null && endTime.compareTo(END_TIME) < 1;
    }
}
