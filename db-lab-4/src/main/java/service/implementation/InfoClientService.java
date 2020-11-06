package service.implementation;

import DAO.IGeneralDAO;
import DAO.implementation.InfoClientDAO;
import model.implementation.InfoClient;

public class InfoClientService extends GeneralService<InfoClient> {
    private final IGeneralDAO<InfoClient, Integer> infoClientDAOImplementation = new InfoClientDAO();

    @Override
    public final IGeneralDAO<InfoClient, Integer> getDAO() {
        return infoClientDAOImplementation;
    }
}
