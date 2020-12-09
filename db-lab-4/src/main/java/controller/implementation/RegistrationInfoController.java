package controller.implementation;

import model.implementation.RegistrationInfo;
import service.IGeneralService;
import service.implementation.GeneralService;
import service.implementation.RegistrationInfoService;

public class RegistrationInfoController extends GeneralController<RegistrationInfo> {

    private final GeneralService<RegistrationInfo> registrationInfoService = new RegistrationInfoService();

    @Override
    public final IGeneralService<RegistrationInfo> getService() {
        return registrationInfoService;
    }
}

