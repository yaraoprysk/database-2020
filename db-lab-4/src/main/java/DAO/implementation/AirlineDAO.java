package DAO.implementation;


import model.implementation.Airline;


public class AirlineDAO extends GeneralDAO<Airline> {
    public final Class<Airline> getClazz() {
        return Airline.class;

    }
}