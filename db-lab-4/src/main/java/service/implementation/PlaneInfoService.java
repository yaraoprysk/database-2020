package service.implementation;

import DAO.IGeneralDAO;
import DAO.implementation.PlaneInfoDAO;
import model.implementation.PlaneInfo;

public class PlaneInfoService extends GeneralService<PlaneInfo> {
    private final IGeneralDAO<PlaneInfo, Integer> planeInfoDAOImplementation = new PlaneInfoDAO();

    @Override
    public final IGeneralDAO<PlaneInfo, Integer> getDAO() {
        return planeInfoDAOImplementation;
    }
}

