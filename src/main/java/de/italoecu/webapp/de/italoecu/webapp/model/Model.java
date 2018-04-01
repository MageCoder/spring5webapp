package de.italoecu.webapp.de.italoecu.webapp.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Car Model
 * @author Andre Schubert <andre.schubert78@gmail.com>
 * @version 1.0
 */
@Entity
public class Model {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
    private String year;
    @OneToOne
    private Brand brand;

    @OneToOne
    private CarType type;

    public Model() {
    }

    public Model(String name, String year, Brand brand, CarType type) {
        this.name = name;
        this.year = year;
        this.brand = brand;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CarType getType() {
        return type;
    }

    public void setType(CarType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Model model = (Model) o;
        return Objects.equals(id, model.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year='" + year + '\'' +
                ", brand=" + brand.getName() +
                ", type=" + type.getType() +
                '}';
    }
}
