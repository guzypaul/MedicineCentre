package by.guzypaul.medicinecentre.entity;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Objects;

/**
 * The type Appointment.
 * @author Guziy Paul
 */
public class Appointment implements Entity {
    private int id;
    private User userClient;
    private Doctor doctor;
    private LocalDate date;
    private Time startTime;
    private Time endTime;
    private Procedure procedure;
    private AppStatus status;

    /**
     * Instantiates a new Appointment.
     */
    public Appointment() {
    }

    /**
     * Instantiates a new Appointment.
     *
     * @param userClient the user client
     * @param doctor     the doctor
     * @param date       the date
     * @param startTime  the start time
     * @param endTime    the end time
     * @param procedure  the procedure
     * @param status     the status
     */
    public Appointment(User userClient, Doctor doctor, LocalDate date, Time startTime, Time endTime, Procedure procedure, AppStatus status) {
        this.userClient = userClient;
        this.doctor = doctor;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.procedure = procedure;
        this.status = status;
    }

    /**
     * Instantiates a new Appointment.
     *
     * @param id         the id
     * @param userClient the user client
     * @param doctor     the doctor
     * @param date       the date
     * @param startTime  the start time
     * @param endTime    the end time
     * @param procedure  the procedure
     * @param status     the status
     */
    public Appointment(int id, User userClient, Doctor doctor, LocalDate date, Time startTime, Time endTime, Procedure procedure, AppStatus status) {
        this.id = id;
        this.userClient = userClient;
        this.doctor = doctor;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.procedure = procedure;
        this.status = status;
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
     * Gets user client.
     *
     * @return the user client
     */
    public User getUserClient() {
        return userClient;
    }

    /**
     * Sets user client.
     *
     * @param userClient the user client
     */
    public void setUserClient(User userClient) {
        this.userClient = userClient;
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
     * Gets procedure.
     *
     * @return the procedure
     */
    public Procedure getProcedure() {
        return procedure;
    }

    /**
     * Sets procedure.
     *
     * @param procedure the procedure
     */
    public void setProcedure(Procedure procedure) {
        this.procedure = procedure;
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(LocalDate date) {
        this.date = date;
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
     * Gets status.
     *
     * @return the status
     */
    public AppStatus getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(AppStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return id == that.id && Objects.equals(userClient, that.userClient) && Objects.equals(doctor, that.doctor) && Objects.equals(date, that.date) && Objects.equals(startTime, that.startTime) && Objects.equals(endTime, that.endTime) && Objects.equals(procedure, that.procedure) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userClient, doctor, date, startTime, endTime, procedure, status);
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", userClient=" + userClient +
                ", doctor=" + doctor +
                ", date=" + date +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", procedure=" + procedure +
                ", status='" + status + '\'' +
                '}' + "\n";
    }
}
