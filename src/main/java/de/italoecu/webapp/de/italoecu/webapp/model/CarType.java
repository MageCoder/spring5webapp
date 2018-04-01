package de.italoecu.webapp.de.italoecu.webapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

/**
 * CarType Model
 * @author Andre Schubert <andre.schubert78@gmail.com>
 * @version 1.0
 */
@Entity
public class CarType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type;

    public CarType(String type) {
        this.type = type;
    }

    public CarType() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarType carType = (CarType) o;
        return Objects.equals(id, carType.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "CarType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
