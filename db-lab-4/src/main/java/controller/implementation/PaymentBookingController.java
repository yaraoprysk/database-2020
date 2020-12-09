package controller.implementation;

import model.implementation.PaymentBooking;
import service.IGeneralService;
import service.implementation.GeneralService;
import service.implementation.PaymentBookingService;

public class PaymentBookingController extends GeneralController<PaymentBooking> {

    private final GeneralService<PaymentBooking> paymentBookingService = new PaymentBookingService();

    @Override
    public final IGeneralService<PaymentBooking> getService() {
        return paymentBookingService;
    }
}
