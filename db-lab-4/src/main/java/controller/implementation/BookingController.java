package controller.implementation;

import model.implementation.Booking;
import service.implementation.BookingService;
import service.implementation.GeneralService;

public class BookingController extends GeneralController<Booking> {

    private static final BookingService BOOKING_SERVICE = new BookingService();

    @Override
    public final GeneralService<Booking> getService() {
        return BOOKING_SERVICE;
    }

}