package model.implementation;

import model.IGeneralModel;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "travel_class", schema = "oprysk_db")
public class TravelClass implements IGeneralModel {
    private static final String tableName = TravelClass.class.getSimpleName();
    private Integer id;
    private String name;

    public TravelClass(){
    }

    public TravelClass(Integer id, String name) {
        this.id = id;
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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TravelClass travelClass = (TravelClass) o;
        return Objects.equals(id, travelClass.id) &&
                Objects.equals(name, travelClass.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "TravelClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}