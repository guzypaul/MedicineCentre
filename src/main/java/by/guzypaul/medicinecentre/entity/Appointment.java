package by.guzypaul.medicinecentre.entity;

import java.sql.Time;
import java.util.Date;
import java.util.Objects;

public class Appointment implements Entity {
    private int id;
    private int clientId;
    private int doctorId;
    private Date date;
    private Time startTime;
    private Time endTime;
    private int procedureId;
    private String status; // todo enum???

    public Appointment() {
    }

    public Appointment(int clientId, int doctorId, Date date, Time startTime, Time endTime, int procedureId,
                       String status) {
        this.clientId = clientId;
        this.doctorId = doctorId;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.procedureId = procedureId;
        this.status = status;
    }

    public Appointment(int id, int clientId, int doctorId, Date date, Time startTime, Time endTime, int procedureId,
                       String status) {
        this.id = id;
        this.clientId = clientId;
        this.doctorId = doctorId;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.procedureId = procedureId;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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

    public int getProcedureId() {
        return procedureId;
    }

    public void setProcedureId(int procedureId) {
        this.procedureId = procedureId;
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
        return id == that.id && clientId == that.clientId && doctorId == that.doctorId
                && procedureId == that.procedureId && Objects.equals(date, that.date)
                && Objects.equals(startTime, that.startTime) && Objects.equals(endTime, that.endTime)
                && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientId, doctorId, date, startTime, endTime, procedureId, status);
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", doctorId=" + doctorId +
                ", date=" + date +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", procedureId=" + procedureId +
                ", status='" + status + '\'' +
                '}';
    }
}
