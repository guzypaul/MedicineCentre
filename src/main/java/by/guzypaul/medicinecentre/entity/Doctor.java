package by.guzypaul.medicinecentre.entity;

import java.util.Objects;

public class Doctor implements Entity {
    private int id;
    private String qualification;
    private String rank;
    private int doctorInfo;

    public Doctor() {
    }

    public Doctor(String qualification, String rank, int doctorInfo) {
        this.qualification = qualification;
        this.rank = rank;
        this.doctorInfo = doctorInfo;
    }

    public Doctor(int id, String qualification, String rank, int doctorInfo) {
        this.id = id;
        this.qualification = qualification;
        this.rank = rank;
        this.doctorInfo = doctorInfo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getDoctorInfo() {
        return doctorInfo;
    }

    public void setDoctorInfo(int doctorInfo) {
        this.doctorInfo = doctorInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return id == doctor.id && doctorInfo == doctor.doctorInfo && Objects.equals(qualification, doctor.qualification) && Objects.equals(rank, doctor.rank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, qualification, rank, doctorInfo);
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", qualification='" + qualification + '\'' +
                ", rank='" + rank + '\'' +
                ", doctorInfo=" + doctorInfo +
                '}';
    }
}
