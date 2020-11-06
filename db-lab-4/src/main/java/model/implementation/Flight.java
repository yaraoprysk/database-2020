package model.implementation;

import model.IGeneralModel;

public class Flight implements IGeneralModel {
    private Integer id;
    private String departurePoint;
    private String destination;

    public Flight(Integer id, String departurePoint, String destination) {
        this.id = id;
        this.departurePoint = departurePoint;
        this.destination = destination;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeparturePoint() {
        return departurePoint;
    }

    public void setDeparturePoint(String departurePoint) {
        this.departurePoint = departurePoint;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
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

