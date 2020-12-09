package service.implementation;

import DAO.IGeneralDAO;
import DAO.implementation.GeneralDAO;
import DAO.implementation.InfoClientDAO;
import model.implementation.InfoClient;

public class InfoClientService extends GeneralService<InfoClient> {
    private final GeneralDAO<InfoClient> INFO_CLIENT_DAO = new InfoClientDAO();

    @Override
    public IGeneralDAO<InfoClient> getDAO() {
        return INFO_CLIENT_DAO;
    }
}