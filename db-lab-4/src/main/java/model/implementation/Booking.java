package model.implementation;

import model.IGeneralModel;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "booking", schema = "oprysk_db")
public class Booking implements IGeneralModel {
    private static final String tableName = Booking.class.getSimpleName();
    private Integer id;
    private Airline airlineByAirlineId;
    private TravelClass travelClassByTravelClassId;
    private Ticket ticketByTicketId;
    private PlaneInfo planeInfoByPlaneInfoId;

    public Booking(){
    }

    public Booking(Integer id, Airline airlineByAirlineId, TravelClass travelClassByTravelClassId,
                   Ticket ticketByTicketId, PlaneInfo planeInfoByPlaneInfoId) {
        this.id = id;
        this.airlineByAirlineId = airlineByAirlineId;
        this.travelClassByTravelClassId = travelClassByTravelClassId;
        this.ticketByTicketId = ticketByTicketId;
        this.planeInfoByPlaneInfoId = planeInfoByPlaneInfoId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(id, booking.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @ManyToOne
    @JoinColumn(name = "airline_id", referencedColumnName = "id", nullable = false)
    public Airline getAirlineByAirlineId() {
        return airlineByAirlineId;
    }

    public void setAirlineByAirlineId(Airline airlineByAirlineId) {
        this.airlineByAirlineId = airlineByAirlineId;
    }

    @ManyToOne
    @JoinColumn(name = "travel_class_id", referencedColumnName = "id", nullable = false)
    public TravelClass getTravelClassByTravelClassId() {
        return travelClassByTravelClassId;
    }

    public void setTravelClassByTravelClassId(TravelClass travelClassByTravelClassId) {
        this.travelClassByTravelClassId = travelClassByTravelClassId;
    }

    @ManyToOne
    @JoinColumn(name = "ticket_id", referencedColumnName = "id", nullable = false)
    public Ticket getTicketByTicketId() {
        return ticketByTicketId;
    }

    public void setTicketByTicketId(Ticket ticketByTicketId) {
        this.ticketByTicketId = ticketByTicketId;
    }

    @ManyToOne
    @JoinColumn(name = "plane_info_id", referencedColumnName = "id", nullable = false)
    public PlaneInfo getPlaneInfoByPlaneInfoId() {
        return planeInfoByPlaneInfoId;
    }

    public void setPlaneInfoByPlaneInfoId(PlaneInfo planeInfoByPlaneInfoId) {
        this.planeInfoByPlaneInfoId = planeInfoByPlaneInfoId;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", airlineByAirlineId=" + airlineByAirlineId +
                ", travelClassByTravelClassId=" + travelClassByTravelClassId +
                ", ticketByTicketId=" + ticketByTicketId +
                ", planeInfoByPlaneInfoId=" + planeInfoByPlaneInfoId +
                '}';
    }
}


