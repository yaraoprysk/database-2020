package DAO.implementation;

import model.implementation.Booking;

public class BookingDAO extends GeneralDAO<Booking> {
    public final Class<Booking> getClazz() {
        return Booking.class;

    }
}