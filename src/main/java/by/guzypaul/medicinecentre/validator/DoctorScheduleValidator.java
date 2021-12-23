package by.guzypaul.medicinecentre.validator;

import by.guzypaul.medicinecentre.entity.Doctor;
import by.guzypaul.medicinecentre.entity.DoctorSchedule;

import java.sql.Time;

public class DoctorScheduleValidator {
    private static final String INFO = "([\\p{Alpha}А-Яа-я]{1,30}[\\s-]?){0,9}"; //todo check varchar 30
    private static final Time MIN_START_TIME = Time.valueOf("08:00:00");
    private static final Time MAX_START_TIME = Time.valueOf("09:00:00");
    private static final Time MIN_END_TIME = Time.valueOf("21:00:00");
    private static final Time MAX_END_TIME = Time.valueOf("22:00:00");

    public boolean validateDoctorSchedule(DoctorSchedule doctorSchedule) {
        return doctorSchedule != null && isValidDoctor(doctorSchedule.getDoctor())
                && isValidStartTime(doctorSchedule.getStartTime())
                && isValidEndTime(doctorSchedule.getEndTime())
                && isValidInfo(doctorSchedule.getInfo());
    }

    private boolean isValidInfo(String text) {
        return text != null && !text.isEmpty() && text.matches(INFO);
    }

    private boolean isValidStartTime(Time startTime) {
        return startTime != null && startTime.compareTo(MAX_START_TIME) < 1 && startTime.compareTo(MIN_START_TIME) > -1;
    }

    private boolean isValidEndTime(Time endTime) {
        return endTime != null && endTime.compareTo(MAX_END_TIME) < 1 && endTime.compareTo(MIN_END_TIME) > -1;
    }

    private boolean isValidDoctor(Doctor doctor) {    //todo double check
        return doctor != null;
    } //todo !!!
}
