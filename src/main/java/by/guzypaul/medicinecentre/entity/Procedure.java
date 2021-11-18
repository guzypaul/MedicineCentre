package by.guzypaul.medicinecentre.entity;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Objects;

public class Procedure implements Entity{
    private int id;
    private String name;
    private String imageName;
    private BigDecimal price;
    private String description;
    private Duration duration;

    public Procedure() {
    }

    public Procedure(String name, String imageName, BigDecimal price, String description, Duration duration) {
        this.name = name;
        this.imageName = imageName;
        this.price = price;
        this.description = description;
        this.duration = duration;
    }

    public Procedure(int id, String name, String imageName, BigDecimal price, String description, Duration duration) {
        this.id = id;
        this.name = name;
        this.imageName = imageName;
        this.price = price;
        this.description = description;
        this.duration = duration;
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

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Procedure procedure = (Procedure) o;
        return id == procedure.id && Objects.equals(name, procedure.name) && Objects.equals(imageName, procedure.imageName) && Objects.equals(price, procedure.price) && Objects.equals(description, procedure.description) && Objects.equals(duration, procedure.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, imageName, price, description, duration);
    }

    @Override
    public String toString() {
        return "Procedure{" +
                "procedureId=" + id +
                ", name='" + name + '\'' +
                ", imageName='" + imageName + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", duration=" + duration +
                '}'  + "\n" ;
    }
}
