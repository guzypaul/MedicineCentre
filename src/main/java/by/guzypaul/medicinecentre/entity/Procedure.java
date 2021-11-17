package by.guzypaul.medicinecentre.entity;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Objects;

public class Procedure implements Entity{
    private int procedureId;
    private String name;
    private String imageName;
    private BigDecimal price;
    private String description;
    private Duration duration;

    public Procedure() {
    }

    public int getProcedureId() {
        return procedureId;
    }

    public void setProcedureId(int procedureId) {
        this.procedureId = procedureId;
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
        return procedureId == procedure.procedureId && Objects.equals(name, procedure.name) && Objects.equals(imageName, procedure.imageName) && Objects.equals(price, procedure.price) && Objects.equals(description, procedure.description) && Objects.equals(duration, procedure.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(procedureId, name, imageName, price, description, duration);
    }

    @Override
    public String toString() {
        return "Procedure{" +
                "procedureId=" + procedureId +
                ", name='" + name + '\'' +
                ", imageName='" + imageName + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", duration=" + duration +
                '}';
    }
}
