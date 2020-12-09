package service.implementation;

import DAO.IGeneralDAO;
import DAO.implementation.CurrentInfoAboutThePlaneDAO;
import DAO.implementation.GeneralDAO;
import model.implementation.CurrentInfoAboutThePlane;

public class CurrentInfoAboutThePlaneService extends GeneralService<CurrentInfoAboutThePlane> {
    private final GeneralDAO<CurrentInfoAboutThePlane> CURRENT_INFO_ABOUT_THE_PLANE_DAO = new CurrentInfoAboutThePlaneDAO();

    @Override
    public IGeneralDAO<CurrentInfoAboutThePlane> getDAO() {
        return CURRENT_INFO_ABOUT_THE_PLANE_DAO;
    }
}