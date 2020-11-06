package model.implementation;

import model.IGeneralModel;

public class Booking implements IGeneralModel {
    private Integer id;
    private Integer airlineId;
    private Integer travelClassId;
    private Integer ticketId;
    private Integer planeInfoId;

    public Booking(Integer id, Integer airlineId, Integer travelClassId, Integer ticketId, Integer planeInfoId) {
        this.id = id;
        this.airlineId = airlineId;
        this.travelClassId = travelClassId;
        this.ticketId = ticketId;
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

    public Integer getTravelClassId() {
        return travelClassId;
    }

    public void setTravelClassId(Integer travelClassId) {
        this.travelClassId = travelClassId;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public Integer getPlaneInfoId() {
        return planeInfoId;
    }

    public void setPlaneInfoId(Integer planeInfoId) {
        this.planeInfoId = planeInfoId;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", airlineId=" + airlineId +
                ", travelClassId=" + travelClassId +
                ", ticketId=" + ticketId +
                ", planeInfoId=" + planeInfoId +
                '}';
    }
}

