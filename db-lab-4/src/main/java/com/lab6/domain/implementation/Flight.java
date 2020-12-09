package com.lab6.domain.implementation;

import com.lab6.domain.IGeneralModel;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "flight", schema = "oprysk_db")
public class Flight implements IGeneralModel {
    private Integer id;
    private String departurePoint;
    private String destination;


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
    @Column(name = "departure_point")
    public String getDeparturePoint() {
        return departurePoint;
    }

    public void setDeparturePoint(String departurePoint) {
        this.departurePoint = departurePoint;
    }

    @Basic
    @Column(name = "destination")
    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return id.equals(flight.id) &&
                departurePoint.equals(flight.departurePoint) &&
                destination.equals(flight.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, departurePoint, destination);
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", departurePoint='" + departurePoint + '\'' +
                ", destination='" + destination + '\'' +
                '}';
    }
}

