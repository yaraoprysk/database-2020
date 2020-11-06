package service.implementation;

import DAO.IGeneralDAO;
import DAO.implementation.CurrentInfoAboutThePlaneDAO;
import model.implementation.CurrentInfoAboutThePlane;

public class CurrentInfoAboutThePlaneService extends GeneralService<CurrentInfoAboutThePlane> {
    private final IGeneralDAO<CurrentInfoAboutThePlane, Integer> currentInfoAboutThePlaneDAOImplementation = new CurrentInfoAboutThePlaneDAO();

    @Override
    public final IGeneralDAO<CurrentInfoAboutThePlane, Integer> getDAO() {
        return currentInfoAboutThePlaneDAOImplementation;
    }
}
