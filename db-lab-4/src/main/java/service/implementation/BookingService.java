package service.implementation;

import DAO.IGeneralDAO;
import DAO.implementation.BookingDAO;
import DAO.implementation.GeneralDAO;
import model.implementation.Booking;

public class BookingService extends GeneralService<Booking> {
    private final GeneralDAO<Booking> BOOKING_DAO = new BookingDAO();

    @Override
    public IGeneralDAO<Booking> getDAO() {
        return BOOKING_DAO;
    }
}