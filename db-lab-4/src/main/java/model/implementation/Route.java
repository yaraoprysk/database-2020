package model.implementation;

import  model.IGeneralModel;

public class Route implements IGeneralModel {
    private Integer id;
    private Integer speedKmPerHours;
    private Integer destinationInKm;

    public Route(Integer id, Integer speedKmPerHours, Integer destinationInKm) {
        this.id = id;
        this.speedKmPerHours = speedKmPerHours;
        this.destinationInKm = destinationInKm;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSpeedKmPerHours() {
        return speedKmPerHours;
    }

    public void setSpeedKmPerHours(Integer speedKmPerHours) {
        this.speedKmPerHours = speedKmPerHours;
    }

    public Integer getDestinationInKm() {
        return destinationInKm;
    }

    public void setDestinationInKm(Integer destinationInKm) {
        this.destinationInKm = destinationInKm;
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
