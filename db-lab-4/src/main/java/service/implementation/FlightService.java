package service.implementation;

import DAO.IGeneralDAO;
import DAO.implementation.FlightDAO;
import model.implementation.Flight;

public class FlightService extends GeneralService<Flight> {
    private final IGeneralDAO<Flight, Integer> flightDAOImplementation = new FlightDAO();

    @Override
    public final IGeneralDAO<Flight, Integer> getDAO() {
        return flightDAOImplementation;
    }
}
