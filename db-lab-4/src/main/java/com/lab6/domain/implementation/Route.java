package com.lab6.domain.implementation;

import com.lab6.domain.IGeneralModel;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "route", schema = "oprysk_db")
public class Route implements IGeneralModel {
    private Integer id;
    private Integer speedKmPerHours;
    private Integer destinationInKm;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
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
        return id.equals(route.id) &&
                speedKmPerHours.equals(route.speedKmPerHours) &&
                destinationInKm.equals(route.destinationInKm);
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
