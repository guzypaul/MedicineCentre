package by.guzypaul.medicinecentre.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class Procedure implements Entity{
    private int id;
    private String name;
    private String imageName;
    private BigDecimal price;
    private String description;
    private int duration;
    private String doctorQualification;

    public Procedure() {
    }

    public Procedure(String name, String imageName, BigDecimal price, String description, int duration, String doctorQualification) {
        this.name = name;
        this.imageName = imageName;
        this.price = price;
        this.description = description;
        this.duration = duration;
        this.doctorQualification = doctorQualification;
    }

    public Procedure(int id, String name, String imageName, BigDecimal price, String description, int duration, String doctorQualification) {
        this.id = id;
        this.name = name;
        this.imageName = imageName;
        this.price = price;
        this.description = description;
        this.duration = duration;
        this.doctorQualification = doctorQualification;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDoctorQualification() {
        return doctorQualification;
    }

    public void setDoctorQualification(String doctorQualification) {
        this.doctorQualification = doctorQualification;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Procedure procedure = (Procedure) o;
        return id == procedure.id && duration == procedure.duration && Objects.equals(name, procedure.name) && Objects.equals(imageName, procedure.imageName) && Objects.equals(price, procedure.price) && Objects.equals(description, procedure.description) && Objects.equals(doctorQualification, procedure.doctorQualification);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, imageName, price, description, duration, doctorQualification);
    }

    @Override
    public String toString() {
        return "Procedure{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imageName='" + imageName + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", duration=" + duration +
                ", doctorQualification='" + doctorQualification + '\'' +
                '}';
    }
}
