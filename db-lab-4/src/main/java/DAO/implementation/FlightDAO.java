package DAO.implementation;

import model.implementation.Flight;

public class FlightDAO extends GeneralDAO<Flight> {
    public final Class<Flight> getClazz() {
        return Flight.class;

    }
}