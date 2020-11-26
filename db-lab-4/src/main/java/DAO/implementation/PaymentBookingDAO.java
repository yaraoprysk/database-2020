package DAO.implementation;

import model.implementation.PaymentBooking;

public class PaymentBookingDAO extends GeneralDAO<PaymentBooking> {
    public final Class<PaymentBooking> getClazz() {
        return PaymentBooking.class;

    }
}