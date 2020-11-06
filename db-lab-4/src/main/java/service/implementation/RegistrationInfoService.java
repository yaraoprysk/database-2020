package service.implementation;

import DAO.IGeneralDAO;
import DAO.implementation.RegistrationInfoDAO;
import model.implementation.RegistrationInfo;

public class RegistrationInfoService extends GeneralService<RegistrationInfo> {
    private final IGeneralDAO<RegistrationInfo, Integer> registrationInfoDAOImplementation = new RegistrationInfoDAO();

    @Override
    public final IGeneralDAO<RegistrationInfo, Integer> getDAO() {
        return registrationInfoDAOImplementation;
    }
}
