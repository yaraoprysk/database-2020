package controller.implementation;

import model.implementation.PaymentBooking;
import service.implementation.GeneralService;
import service.implementation.PaymentBookingService;

public class PaymentBookingController extends GeneralController<PaymentBooking> {

    private static final PaymentBookingService PAYMENT_BOOKING_SERVICE = new PaymentBookingService();

    @Override
    public final GeneralService<PaymentBooking> getService() {
        return PAYMENT_BOOKING_SERVICE;
    }

}