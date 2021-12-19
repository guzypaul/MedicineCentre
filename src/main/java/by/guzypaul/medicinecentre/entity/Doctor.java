package by.guzypaul.medicinecentre.entity;

import java.util.Objects;

public class Doctor implements Entity {
    private int id;
    private String qualification;
    private String rank;
    private User doctorInfo;

    public Doctor() {
    }

    public Doctor(String qualification, String rank, User doctorInfo) {
        this.qualification = qualification;
        this.rank = rank;
        this.doctorInfo = doctorInfo;
    }

    public Doctor(int id, String qualification, String rank, User doctorInfo) {
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

    public User getDoctorInfo() {
        return doctorInfo;
    }

    public void setDoctorInfo(User doctorInfo) {
        this.doctorInfo = doctorInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return id == doctor.id && Objects.equals(qualification, doctor.qualification) && Objects.equals(rank, doctor.rank) && Objects.equals(doctorInfo, doctor.doctorInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, qualification, rank, doctorInfo);
    }

    @Override
    public String toString() {
        return "Doctor {" + "\n" +
                "id=" + id + ",\n" +
                "qualification='" + qualification + '\'' + ",\n" +
                "rank='" + rank + '\'' + ",\n" +
                "doctorInfo = " + doctorInfo + '}' ;
    }
}
