package controller.implementation;

import model.implementation.RegistrationInfo;
import service.implementation.GeneralService;
import service.implementation.RegistrationInfoService;

public class RegistrationInfoController extends GeneralController<RegistrationInfo> {

    private static final RegistrationInfoService REGISTRATION_INFO_SERVICE = new RegistrationInfoService();

    @Override
    public final GeneralService<RegistrationInfo> getService() {
        return REGISTRATION_INFO_SERVICE;
    }

}
