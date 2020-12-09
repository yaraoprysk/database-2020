package model.implementation;

import  model.IGeneralModel;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "route", schema = "oprysk_db")
public class Route implements IGeneralModel {
    private static final String tableName = Route.class.getSimpleName();
    private Integer id;
    private Integer speedKmPerHours;
    private Integer destinationInKm;

    public Route() {
    }

    public Route(Integer id, Integer speedKmPerHours, Integer destinationInKm) {
        this.id = id;
        this.speedKmPerHours = speedKmPerHours;
        this.destinationInKm = destinationInKm;
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
    @Column(name = "speed_km_per_hour")
    public Integer getSpeedKmPerHours() {
        return speedKmPerHours;
    }

    public void setSpeedKmPerHours(Integer speedKmPerHours) {
        this.speedKmPerHours = speedKmPerHours;
    }

    @Basic
    @Column(name = "destination_in_km")
    public Integer getDestinationInKm() {
        return destinationInKm;
    }

    public void setDestinationInKm(Integer destinationInKm) {
        this.destinationInKm = destinationInKm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return Objects.equals(id, route.id) &&
                Objects.equals(speedKmPerHours, route.speedKmPerHours) &&
                Objects.equals(destinationInKm, route.destinationInKm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, speedKmPerHours, destinationInKm);
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", speedKmPerHours=" + speedKmPerHours +
                ", destinationInKm='" + destinationInKm + '\'' +
                '}';
    }
}
