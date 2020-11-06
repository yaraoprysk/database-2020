package model.implementation;

import model.IGeneralModel;

public class Schedule implements IGeneralModel {
    private Integer id;
    private String arrivalTime;
    private String departureTime;

    public Schedule(Integer id, String arrivalTime, String departureTime) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", departureTime='" + departureTime + '\'' +
                '}';
    }
}
