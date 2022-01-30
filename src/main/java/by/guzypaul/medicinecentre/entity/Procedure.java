package by.guzypaul.medicinecentre.entity;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * The type Procedure.
 */
public class Procedure implements Entity{
    private int id;
    private String name;
    private String imageName;
    private BigDecimal price;
    private String description;
    private int duration;
    private String doctorQualification;

    /**
     * Instantiates a new Procedure.
     */
    public Procedure() {
    }

    /**
     * Instantiates a new Procedure.
     *
     * @param name                the name
     * @param imageName           the image name
     * @param price               the price
     * @param description         the description
     * @param duration            the duration
     * @param doctorQualification the doctor qualification
     */
    public Procedure(String name, String imageName, BigDecimal price, String description, int duration, String doctorQualification) {
        this.name = name;
        this.imageName = imageName;
        this.price = price;
        this.description = description;
        this.duration = duration;
        this.doctorQualification = doctorQualification;
    }

    /**
     * Instantiates a new Procedure.
     *
     * @param id                  the id
     * @param name                the name
     * @param imageName           the image name
     * @param price               the price
     * @param description         the description
     * @param duration            the duration
     * @param doctorQualification the doctor qualification
     */
    public Procedure(int id, String name, String imageName, BigDecimal price, String description, int duration, String doctorQualification) {
        this.id = id;
        this.name = name;
        this.imageName = imageName;
        this.price = price;
        this.description = description;
        this.duration = duration;
        this.doctorQualification = doctorQualification;
    }

    /**
     * Instantiates a new Procedure.
     *
     * @param name                the name
     * @param price               the price
     * @param description         the description
     * @param duration            the duration
     * @param doctorQualification the doctor qualification
     */
    public Procedure(String name, BigDecimal price, String description, int duration, String doctorQualification) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.duration = duration;
        this.doctorQualification = doctorQualification;
    }

    /**
     * Instantiates a new Procedure.
     *
     * @param id                  the id
     * @param name                the name
     * @param price               the price
     * @param description         the description
     * @param duration            the duration
     * @param doctorQualification the doctor qualification
     */
    public Procedure(int id, String name, BigDecimal price, String description, int duration, String doctorQualification) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.duration = duration;
        this.doctorQualification = doctorQualification;
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
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets image name.
     *
     * @return the image name
     */
    public String getImageName() {
        return imageName;
    }

    /**
     * Sets image name.
     *
     * @param imageName the image name
     */
    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets duration.
     *
     * @return the duration
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Sets duration.
     *
     * @param duration the duration
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * Gets doctor qualification.
     *
     * @return the doctor qualification
     */
    public String getDoctorQualification() {
        return doctorQualification;
    }

    /**
     * Sets doctor qualification.
     *
     * @param doctorQualification the doctor qualification
     */
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
