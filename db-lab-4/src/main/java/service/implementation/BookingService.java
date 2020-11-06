package service.implementation;

import DAO.IGeneralDAO;
import DAO.implementation.BookingDAO;
import model.implementation.Booking;

public class BookingService extends GeneralService<Booking> {
    private final IGeneralDAO<Booking, Integer> bookingDAOImplementation = new BookingDAO();

    @Override
    public final IGeneralDAO<Booking, Integer> getDAO() {
        return bookingDAOImplementation;
    }
}