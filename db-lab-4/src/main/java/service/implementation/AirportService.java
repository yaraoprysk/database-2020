package service.implementation;

import DAO.IGeneralDAO;
import DAO.implementation.AirportDAO;
import DAO.implementation.GeneralDAO;
import model.implementation.Airport;

public class AirportService extends GeneralService<Airport> {
    private final GeneralDAO<Airport> AIRPORT_DAO = new AirportDAO();

    @Override
    public IGeneralDAO<Airport> getDAO() {
        return AIRPORT_DAO;
    }
}
