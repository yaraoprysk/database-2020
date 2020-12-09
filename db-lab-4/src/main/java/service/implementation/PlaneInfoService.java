package service.implementation;

import DAO.IGeneralDAO;
import DAO.implementation.GeneralDAO;
import DAO.implementation.PlaneInfoDAO;
import model.implementation.PlaneInfo;

public class PlaneInfoService extends GeneralService<PlaneInfo> {
    private final GeneralDAO<PlaneInfo> PLANE_INFO_DAO = new PlaneInfoDAO();

    @Override
    public IGeneralDAO<PlaneInfo> getDAO() {
        return PLANE_INFO_DAO;
    }
}


