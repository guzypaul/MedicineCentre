package by.guzypaul.medicinecentre.entity;

import java.util.Objects;

/**
 * The type Doctor.
 * @author Guziy Paul
 */
public class Doctor implements Entity {
    private int id;
    private String qualification;
    private String rank;
    private User doctorInfo;
    private String photoName;

    /**
     * Instantiates a new Doctor.
     */
    public Doctor() {
    }

    /**
     * Instantiates a new Doctor.
     *
     * @param qualification the qualification
     * @param rank          the rank
     * @param doctorInfo    the doctor info
     * @param photoName     the photo name
     */
    public Doctor(String qualification, String rank, User doctorInfo, String photoName) {
        this.qualification = qualification;
        this.rank = rank;
        this.doctorInfo = doctorInfo;
        this.photoName = photoName;
    }

    /**
     * Instantiates a new Doctor.
     *
     * @param id            the id
     * @param qualification the qualification
     * @param rank          the rank
     * @param doctorInfo    the doctor info
     * @param photoName     the photo name
     */
    public Doctor(int id, String qualification, String rank, User doctorInfo, String photoName) {
        this.id = id;
        this.qualification = qualification;
        this.rank = rank;
        this.doctorInfo = doctorInfo;
        this.photoName = photoName;
    }

    /**
     * Instantiates a new Doctor.
     *
     * @param id            the id
     * @param qualification the qualification
     * @param rank          the rank
     * @param photoName     the photo name
     */
    public Doctor(int id, String qualification, String rank, String photoName) {
        this.id = id;
        this.qualification = qualification;
        this.rank = rank;
        this.photoName = photoName;
    }

    /**
     * Instantiates a new Doctor.
     *
     * @param qualification the qualification
     * @param rank          the rank
     * @param doctorInfo    the doctor info
     */
    public Doctor(String qualification, String rank, User doctorInfo) {
        this.qualification = qualification;
        this.rank = rank;
        this.doctorInfo = doctorInfo;
    }

    /**
     * Instantiates a new Doctor.
     *
     * @param id            the id
     * @param qualification the qualification
     * @param rank          the rank
     */
    public Doctor(int id, String qualification, String rank) {
        this.id = id;
        this.qualification = qualification;
        this.rank = rank;
    }

    /**
     * Gets photo name.
     *
     * @return the photo name
     */
    public String getPhotoName() {
        return photoName;
    }

    /**
     * Sets photo name.
     *
     * @param photoName the photo name
     */
    public void setPhotoName(String photoName) {
        this.photoName = photoName;
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
     * Gets qualification.
     *
     * @return the qualification
     */
    public String getQualification() {
        return qualification;
    }

    /**
     * Sets qualification.
     *
     * @param qualification the qualification
     */
    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    /**
     * Gets rank.
     *
     * @return the rank
     */
    public String getRank() {
        return rank;
    }

    /**
     * Sets rank.
     *
     * @param rank the rank
     */
    public void setRank(String rank) {
        this.rank = rank;
    }

    /**
     * Gets doctor info.
     *
     * @return the doctor info
     */
    public User getDoctorInfo() {
        return doctorInfo;
    }

    /**
     * Sets doctor info.
     *
     * @param doctorInfo the doctor info
     */
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
