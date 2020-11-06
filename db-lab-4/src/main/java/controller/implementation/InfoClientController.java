package controller.implementation;

import model.implementation.InfoClient;
import service.implementation.GeneralService;
import service.implementation.InfoClientService;


public class InfoClientController extends GeneralController<InfoClient> {

    private static final InfoClientService INFO_CLIENT_SERVICE = new InfoClientService();

    @Override
    public final GeneralService<InfoClient> getService() {
        return INFO_CLIENT_SERVICE;
    }

}