package DAO.implementation;

import model.implementation.Client;

public class ClientDAO extends GeneralDAO<Client> {
    public final Class<Client> getClazz() {
        return Client.class;

    }
}
