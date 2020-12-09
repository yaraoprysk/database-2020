package service.implementation;

import DAO.IGeneralDAO;
import DAO.implementation.GeneralDAO;
import DAO.implementation.RegistrationInfoDAO;
import model.implementation.RegistrationInfo;

public class RegistrationInfoService extends GeneralService<RegistrationInfo> {
    private final GeneralDAO<RegistrationInfo> REGISTRATION_INFO_DAO = new RegistrationInfoDAO();

    @Override
    public IGeneralDAO<RegistrationInfo> getDAO() {
        return REGISTRATION_INFO_DAO;
    }
}