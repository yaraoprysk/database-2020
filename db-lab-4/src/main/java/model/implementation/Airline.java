package model.implementation;

import model.IGeneralModel;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "airline", schema = "oprysk_db")
public class Airline implements IGeneralModel {
    private static final String tableName = Airline.class.getSimpleName();
    private Integer id;
    private String name;
    private String country;


    public Airline(Integer id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public Airline() {

    }

    public static String getTableName() {
        return tableName;
    }


    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airline airline = (Airline) o;
        return Objects.equals(id, airline.id) &&
                Objects.equals(name, airline.name) &&
                Objects.equals(country, airline.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, country);
    }


    @Override
    public String toString() {
        return "Airline{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
