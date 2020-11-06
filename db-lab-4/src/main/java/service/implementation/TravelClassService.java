package service.implementation;

import DAO.IGeneralDAO;
import DAO.implementation.TravelClassDAO;
import model.implementation.TravelClass;

public class TravelClassService extends GeneralService<TravelClass> {
    private final IGeneralDAO<TravelClass, Integer> travelClassDAOImplementation = new TravelClassDAO();

    @Override
    public final IGeneralDAO<TravelClass, Integer> getDAO() {
        return travelClassDAOImplementation;
    }
}