package by.guzypaul.medicinecentre.entity;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Objects;

public class Appointment implements Entity {
    private int id;
    private User userClient;
    private Doctor doctor;
    private LocalDate date;
    private Time startTime;
    private Time endTime;
    private Procedure procedure;
    private String status;

    public Appointment() {
    }

    public Appointment(User userClient, Doctor doctor, LocalDate date, Time startTime, Time endTime, Procedure procedure, String status) {
        this.userClient = userClient;
        this.doctor = doctor;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.procedure = procedure;
        this.status = status;
    }

    public Appointment(int id, User userClient, Doctor doctor, LocalDate date, Time startTime, Time endTime, Procedure procedure, String status) {
        this.id = id;
        this.userClient = userClient;
        this.doctor = doctor;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.procedure = procedure;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUserClient() {
        return userClient;
    }

    public void setUserClient(User userClient) {
        this.userClient = userClient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Procedure getProcedure() {
        return procedure;
    }

    public void setProcedure(Procedure procedure) {
        this.procedure = procedure;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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
