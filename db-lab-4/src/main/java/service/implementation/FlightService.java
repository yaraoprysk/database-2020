package service.implementation;

import DAO.IGeneralDAO;
import DAO.implementation.FlightDAO;
import DAO.implementation.GeneralDAO;
import model.implementation.Flight;

public class FlightService extends GeneralService<Flight> {
    private final GeneralDAO<Flight> FLIGHT_DAO = new FlightDAO();

    @Override
    public IGeneralDAO<Flight> getDAO() {
        return FLIGHT_DAO;
    }
}