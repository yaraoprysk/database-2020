package service.implementation;

import DAO.IGeneralDAO;
import DAO.implementation.ClientDAO;
import DAO.implementation.GeneralDAO;
import model.implementation.Client;

public class ClientService extends GeneralService<Client> {
    private final GeneralDAO<Client> CLIENT_DAO = new ClientDAO();

    @Override
    public IGeneralDAO<Client> getDAO() {
        return CLIENT_DAO;
    }
}