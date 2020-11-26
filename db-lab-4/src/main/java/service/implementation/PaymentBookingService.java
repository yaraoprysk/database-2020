package service.implementation;

import DAO.IGeneralDAO;
import DAO.implementation.GeneralDAO;
import DAO.implementation.PaymentBookingDAO;
import model.implementation.PaymentBooking;

public class PaymentBookingService extends GeneralService<PaymentBooking> {
    private final GeneralDAO<PaymentBooking> PAYMENT_BOOKING_DAO = new PaymentBookingDAO();

    @Override
    public IGeneralDAO<PaymentBooking> getDAO() {
        return PAYMENT_BOOKING_DAO;
    }
}
