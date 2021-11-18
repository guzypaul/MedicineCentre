package by.guzypaul.medicinecentre.entity;

import java.sql.Time;
import java.util.Objects;

public class DoctorSchedule implements Entity{
    private int id;
    private int doctorId;
    private Time startTime;
    private Time endTime;
    private String info;

    public DoctorSchedule() {
    }

    public DoctorSchedule(int doctorId, Time startTime, Time endTime, String info) {
        this.doctorId = doctorId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.info = info;
    }

    public DoctorSchedule(int id, int doctorId, Time startTime, Time endTime, String info) {
        this.id = id;
        this.doctorId = doctorId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.info = info;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoctorSchedule that = (DoctorSchedule) o;
        return id == that.id && doctorId == that.doctorId && Objects.equals(startTime, that.startTime) && Objects.equals(endTime, that.endTime) && Objects.equals(info, that.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, doctorId, startTime, endTime, info);
    }

    @Override
    public String toString() {
        return "DoctorSchedule{" +
                "id=" + id +
                ", doctorId=" + doctorId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", info='" + info + '\'' +
                '}';
    }
}
