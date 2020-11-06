package model.implementation;

import model.IGeneralModel;

public class CurrentInfoAboutThePlane implements IGeneralModel {
    private Integer id;
    private Integer airlineId;
    private Integer airportId;
    private Integer registrationInfoId;
    private Integer flightId;
    private Integer routeId;
    private Integer scheduleId;
    private Integer planeInfoId;

    public CurrentInfoAboutThePlane(Integer id, Integer airlineId, Integer airportId, Integer registrationInfoId,
                                    Integer flightId, Integer routeId, Integer scheduleId, Integer planeInfoId) {
        this.id = id;
        this.airlineId = airlineId;
        this.airportId = airportId;
        this.registrationInfoId = registrationInfoId;
        this.flightId = flightId;
        this.routeId = routeId;
        this.scheduleId = scheduleId;
        this.planeInfoId = planeInfoId;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(Integer airlineId) {
        this.airlineId = airlineId;
    }

    public Integer getAirportId() {
        return airportId;
    }

    public void setAirportId(Integer airportId) {
        this.airportId = airportId;
    }

    public Integer getRegistrationInfoId() {
        return registrationInfoId;
    }

    public void setRegistrationInfoId(Integer registrationInfoId) {
        this.registrationInfoId = registrationInfoId;
    }

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Integer getPlaneInfoId() {
        return planeInfoId;
    }

    public void setPlaneInfoId(Integer planeInfoId) {
        this.planeInfoId = planeInfoId;
    }

    @Override
    public String toString() {
        return "CurrentInfoAboutThePlane{" +
                "id=" + id +
                ", airlineId=" + airlineId +
                ", airportId=" + airportId +
                ", registrationInfoId=" + registrationInfoId +
                ", flightId=" + flightId +
                ", routeId=" + routeId +
                ", scheduleId=" + scheduleId +
                ", planeInfoId=" + planeInfoId +
                '}';
    }
}
