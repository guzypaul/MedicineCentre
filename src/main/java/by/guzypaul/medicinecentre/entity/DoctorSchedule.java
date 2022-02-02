package by.guzypaul.medicinecentre.entity;

import java.sql.Time;
import java.util.Objects;

/**
 * The type Doctor schedule.
 * @author Guziy Paul
 */
public class DoctorSchedule implements Entity{
    private int id;
    private Doctor doctor;
    private Time startTime;
    private Time endTime;
    private String info;

    /**
     * Instantiates a new Doctor schedule.
     */
    public DoctorSchedule() {
    }

    /**
     * Instantiates a new Doctor schedule.
     *
     * @param doctor    the doctor
     * @param startTime the start time
     * @param endTime   the end time
     * @param info      the info
     */
    public DoctorSchedule(Doctor doctor, Time startTime, Time endTime, String info) {
        this.doctor = doctor;
        this.startTime = startTime;
        this.endTime = endTime;
        this.info = info;
    }

    /**
     * Instantiates a new Doctor schedule.
     *
     * @param id        the id
     * @param doctor    the doctor
     * @param startTime the start time
     * @param endTime   the end time
     * @param info      the info
     */
    public DoctorSchedule(int id, Doctor doctor, Time startTime, Time endTime, String info) {
        this.id = id;
        this.doctor = doctor;
        this.startTime = startTime;
        this.endTime = endTime;
        this.info = info;
    }

    /**
     * Instantiates a new Doctor schedule.
     *
     * @param id        the id
     * @param startTime the start time
     * @param endTime   the end time
     * @param info      the info
     */
    public DoctorSchedule(int id, Time startTime, Time endTime, String info) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.info = info;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets doctor.
     *
     * @return the doctor
     */
    public Doctor getDoctor() {
        return doctor;
    }

    /**
     * Sets doctor.
     *
     * @param doctor the doctor
     */
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    /**
     * Gets start time.
     *
     * @return the start time
     */
    public Time getStartTime() {
        return startTime;
    }

    /**
     * Sets start time.
     *
     * @param startTime the start time
     */
    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    /**
     * Gets end time.
     *
     * @return the end time
     */
    public Time getEndTime() {
        return endTime;
    }

    /**
     * Sets end time.
     *
     * @param endTime the end time
     */
    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    /**
     * Gets info.
     *
     * @return the info
     */
    public String getInfo() {
        return info;
    }

    /**
     * Sets info.
     *
     * @param info the info
     */
    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoctorSchedule that = (DoctorSchedule) o;
        return id == that.id && Objects.equals(doctor, that.doctor) && Objects.equals(startTime, that.startTime) && Objects.equals(endTime, that.endTime) && Objects.equals(info, that.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, doctor, startTime, endTime, info);
    }

    @Override
    public String toString() {
        return "DoctorSchedule {" +
                "id=" + id + ",\n" +
                "doctor=" + doctor + ",\n" +
                "startTime=" + startTime + ",\n" +
                "endTime=" + endTime + ",\n" +
                "info = '" + info + '\'' +
                '}' + "\n\n";
    }
}
