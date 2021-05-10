package com.lab6.domain.implementation;

import com.lab6.domain.IGeneralModel;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "current_info_about_the_plane", schema = "oprysk_db")
public class CurrentInfoAboutThePlane implements IGeneralModel {
    private Integer id;
    private Airline airlineByAirlineId;
    private Airport airportByAirportId;
    private RegistrationInfo registrationInfoByRegistrationInfoId;
    private Flight flightByFlightId;
    private Route routeByRouteId;
    private PlaneInfo planeInfoByPlaneInfoId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
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
        CurrentInfoAboutThePlane currentInfoAboutThePlane = (CurrentInfoAboutThePlane) o;
        return id.equals(currentInfoAboutThePlane.id);
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
    @JoinColumn(name = "airport_id", referencedColumnName = "id", nullable = false)
    public Airport getAirportByAirportId() {
        return airportByAirportId;
    }

    public void setAirportByAirportId(Airport airportByAirportId) {
        this.airportByAirportId = airportByAirportId;
    }

    @ManyToOne
    @JoinColumn(name = "registration_info_id", referencedColumnName = "id", nullable = false)
    public RegistrationInfo getRegistrationInfoByRegistrationInfoId() {
        return registrationInfoByRegistrationInfoId;
    }

    public void setRegistrationInfoByRegistrationInfoId(RegistrationInfo registrationInfoByRegistrationInfoId) {
        this.registrationInfoByRegistrationInfoId = registrationInfoByRegistrationInfoId;
    }

    @ManyToOne
    @JoinColumn(name = "flight_id", referencedColumnName = "id", nullable = false)
    public Flight getFlightByFlightId() {
        return flightByFlightId;
    }

    public void setFlightByFlightId(Flight flightByFlightId) {
        this.flightByFlightId = flightByFlightId;
    }

    @ManyToOne
    @JoinColumn(name = "route_id", referencedColumnName = "id", nullable = false)
    public Route getRouteByRouteId() {
        return routeByRouteId;
    }

    public void setRouteByRouteId(Route routeByRouteId) {
        this.routeByRouteId = routeByRouteId;
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
        return "CurrentInfoAboutThePlane{" +
                "id=" + id +
                ", airlineByAirlineId=" + airlineByAirlineId +
                ", airportByAirportId=" + airportByAirportId +
                ", registrationInfoByRegistrationInfoId=" + registrationInfoByRegistrationInfoId +
                ", flightByFlightId=" + flightByFlightId +
                ", routeByRouteId=" + routeByRouteId +
                ", planeInfoByPlaneInfoId=" + planeInfoByPlaneInfoId +
                '}';
    }
}
