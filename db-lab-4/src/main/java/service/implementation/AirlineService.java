package service.implementation;

import DAO.IGeneralDAO;
import DAO.implementation.AirlineDAO;
import model.implementation.Airline;

public class AirlineService extends GeneralService<Airline> {
    private final IGeneralDAO<Airline, Integer> airlineDAOImplementation = new AirlineDAO();

    @Override
    public final IGeneralDAO<Airline, Integer> getDAO() {
        return airlineDAOImplementation;
    }
}
