package controller.implementation;

import model.implementation.Booking;
import service.IGeneralService;
import service.implementation.BookingService;
import service.implementation.GeneralService;

public class BookingController extends GeneralController<Booking> {

    private final GeneralService<Booking> bookingService = new BookingService();

    @Override
    public final IGeneralService<Booking> getService() {
        return bookingService;
    }
}
