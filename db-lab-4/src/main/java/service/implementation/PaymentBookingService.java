package service.implementation;

import DAO.IGeneralDAO;
import DAO.implementation.PaymentBookingDAO;
import model.implementation.PaymentBooking;

public class PaymentBookingService extends GeneralService<PaymentBooking> {
    private final IGeneralDAO<PaymentBooking, Integer> paymentBookingDAOImplementation = new PaymentBookingDAO();

    @Override
    public final IGeneralDAO<PaymentBooking, Integer> getDAO() {
        return paymentBookingDAOImplementation;
    }
}
