package service.implementation;

import DAO.IGeneralDAO;
import DAO.implementation.ClientDAO;
import model.implementation.Client;

public class ClientService extends GeneralService<Client> {
    private final IGeneralDAO<Client, Integer> clientDAOImplementation = new ClientDAO();

    @Override
    public final IGeneralDAO<Client, Integer> getDAO() {
        return clientDAOImplementation;
    }
}