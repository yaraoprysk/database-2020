package DAO.implementation;

import model.implementation.Airport;

public class AirportDAO extends GeneralDAO<Airport> {
    public final Class<Airport> getClazz() {
        return Airport.class;

    }
}