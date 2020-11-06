package controller.implementation;

import model.implementation.Client;
import service.implementation.ClientService;
import service.implementation.GeneralService;

public class ClientController extends GeneralController<Client> {

    private static final ClientService CLIENT_SERVICE = new ClientService();

    @Override
    public final GeneralService<Client> getService() {
        return CLIENT_SERVICE;
    }

}
