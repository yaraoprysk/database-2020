package controller.implementation;

import model.implementation.InfoClient;
import service.IGeneralService;
import service.implementation.GeneralService;
import service.implementation.InfoClientService;


public class InfoClientController extends GeneralController<InfoClient> {

    private final GeneralService<InfoClient> infoClientService = new InfoClientService();

    @Override
    public final IGeneralService<InfoClient> getService() {
        return infoClientService;
    }
}
