package service.implementation;

import DAO.IGeneralDAO;
import DAO.implementation.AirportDAO;
import model.implementation.Airport;

public class AirportService extends GeneralService<Airport> {
    private final IGeneralDAO<Airport, Integer> airportDAOImplementation = new AirportDAO();

    @Override
    public final IGeneralDAO<Airport, Integer> getDAO() {
        return airportDAOImplementation;
    }
}
