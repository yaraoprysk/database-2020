package service.implementation;

import DAO.IGeneralDAO;
import DAO.implementation.AirlineDAO;
import DAO.implementation.GeneralDAO;
import model.implementation.Airline;

public class AirlineService extends GeneralService<Airline> {
    private final GeneralDAO<Airline> AIRLINE_DAO = new AirlineDAO();

    @Override
    public IGeneralDAO<Airline> getDAO() {
        return AIRLINE_DAO;
    }
}
