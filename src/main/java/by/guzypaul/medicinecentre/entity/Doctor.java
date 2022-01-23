package by.guzypaul.medicinecentre.entity;

import java.util.Objects;

public class Doctor implements Entity {
    private int id;
    private String qualification;
    private String rank;
    private User doctorInfo;
    private String photoName;

    public Doctor() {
    }

    public Doctor(String qualification, String rank, User doctorInfo, String photoName) {
        this.qualification = qualification;
        this.rank = rank;
        this.doctorInfo = doctorInfo;
        this.photoName = photoName;
    }

    public Doctor(int id, String qualification, String rank, User doctorInfo, String photoName) {
        this.id = id;
        this.qualification = qualification;
        this.rank = rank;
        this.doctorInfo = doctorInfo;
        this.photoName = photoName;
    }

    public Doctor(int id, String qualification, String rank, String photoName) {
        this.id = id;
        this.qualification = qualification;
        this.rank = rank;
        this.photoName = photoName;
    }

    public Doctor(String qualification, String rank, User doctorInfo) {
        this.qualification = qualification;
        this.rank = rank;
        this.doctorInfo = doctorInfo;
    }

    public Doctor(int id, String qualification, String rank) {
        this.id = id;
        this.qualification = qualification;
        this.rank = rank;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
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
        return id == doctor.id && Objects.equals(qualification, doctor.qualification) && Objects.equals(rank, doctor.rank) && Objects.equals(doctorInfo, doctor.doctorInfo) && Objects.equals(photoName, doctor.photoName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, qualification, rank, doctorInfo, photoName);
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", qualification='" + qualification + '\'' +
                ", rank='" + rank + '\'' +
                ", doctorInfo=" + doctorInfo +
                ", photoName='" + photoName + '\'' +
                '}';
    }
}
