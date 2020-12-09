package model.implementation;

import model.IGeneralModel;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "flight", schema = "oprysk_db")
public class Flight implements IGeneralModel {
    private static final String tableName = Flight.class.getSimpleName();
    private Integer id;
    private String departurePoint;
    private String destination;

    public Flight(){
    }

    public Flight(Integer id, String departurePoint, String destination) {
        this.id = id;
        this.departurePoint = departurePoint;
        this.destination = destination;
    }

    public static String getTableName() {
        return tableName;
    }

    @Id
    @Column(name= "id")
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
        return Objects.equals(id, flight.id) &&
                Objects.equals(departurePoint, flight.departurePoint) &&
                Objects.equals(destination, flight.destination);
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

