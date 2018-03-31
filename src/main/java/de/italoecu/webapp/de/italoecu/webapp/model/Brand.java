package de.italoecu.webapp.de.italoecu.webapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Car Brand
 * @author Andre Schubert <andre.schubert78@gmail.com>
 * @version 1.0
 */
@Entity
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToOne
    private Country country;
    private Integer foundedIn;

    @OneToMany
    private Set<Model> models = new HashSet<>();


    public Brand() {
    }

    public Brand(String name, Country country, Integer foundedIn) {
        this.name = name;
        this.country = country;
        this.foundedIn = foundedIn;
    }

    public Set<Model> getModels() {
        return models;
    }

    public void setModels(Set<Model> models) {
        this.models = models;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Integer getFoundedIn() {
        return foundedIn;
    }

    public void setFoundedIn(Integer foundedIn) {
        this.foundedIn = foundedIn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Brand brand = (Brand) o;
        return Objects.equals(id, brand.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country.getName() + '\'' +
                ", foundedIn=" + foundedIn +
                ", models=" + models +
                '}';
    }
}
