package by.guzypaul.medicinecentre.entity;

import java.sql.Time;
import java.util.Date;
import java.util.Objects;

public class DoctorSchedule implements Entity{
    private int id;
    private Doctor doctor;
    private Time startTime;
    private Time endTime;
    private Date date;
    private String info;

    public DoctorSchedule() {
    }

    public DoctorSchedule(Doctor doctor, Time startTime, Time endTime, Date date, String info) {
        this.doctor = doctor;
        this.startTime = startTime;
        this.endTime = endTime;
        this.date = date;
        this.info = info;
    }

    public DoctorSchedule(int id, Doctor doctor, Time startTime, Time endTime, Date date, String info) {
        this.id = id;
        this.doctor = doctor;
        this.startTime = startTime;
        this.endTime = endTime;
        this.date = date;
        this.info = info;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoctorSchedule that = (DoctorSchedule) o;
        return id == that.id && Objects.equals(doctor, that.doctor) && Objects.equals(startTime, that.startTime) && Objects.equals(endTime, that.endTime) && Objects.equals(date, that.date) && Objects.equals(info, that.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, doctor, startTime, endTime, date, info);
    }

    @Override
    public String toString() {
        return "DoctorSchedule {" +
                "id=" + id + ",\n" +
                "doctor=" + doctor + ",\n" +
                "startTime=" + startTime + ",\n" +
                "endTime=" + endTime + ",\n" +
                "date=" + date + ",\n" +
                "info = '" + info + '\'' +
                '}' + "\n\n";
    }
}
