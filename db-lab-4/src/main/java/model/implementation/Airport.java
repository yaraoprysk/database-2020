package model.implementation;

import model.IGeneralModel;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "airport", schema = "oprysk_db")
public class Airport implements IGeneralModel {
    private static final String tableName = Airport.class.getSimpleName();
    private Integer id;
    private String city;
    private String name;

    public Airport(){
    }

    public Airport(Integer id, String city, String name) {
        this.id = id;
        this.city = city;
        this.name = name;
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
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport airport = (Airport) o;
        return Objects.equals(id, airport.id) &&
                Objects.equals(city, airport.city) &&
                Objects.equals(name, airport.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, city, name);
    }

    @Override
    public String toString() {
        return "Airport{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

