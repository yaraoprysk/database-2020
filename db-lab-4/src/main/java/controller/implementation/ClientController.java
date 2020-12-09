package controller.implementation;

import model.implementation.Client;
import service.IGeneralService;
import service.implementation.ClientService;
import service.implementation.GeneralService;

public class ClientController extends GeneralController<Client> {

    private final GeneralService<Client> clientService = new ClientService();

    @Override
    public final IGeneralService<Client> getService() {
        return clientService;
    }
}

