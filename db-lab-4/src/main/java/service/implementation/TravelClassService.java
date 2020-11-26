package service.implementation;

import DAO.IGeneralDAO;
import DAO.implementation.GeneralDAO;
import DAO.implementation.TravelClassDAO;
import model.implementation.TravelClass;

public class TravelClassService extends GeneralService<TravelClass> {
    private final GeneralDAO<TravelClass> TRAVEL_CLASS_DAO = new TravelClassDAO();

    @Override
    public IGeneralDAO<TravelClass> getDAO() {
        return TRAVEL_CLASS_DAO;
    }
}