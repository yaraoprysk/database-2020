package controller.implementation;

import model.implementation.CurrentInfoAboutThePlane;
import service.implementation.CurrentInfoAboutThePlaneService;
import service.implementation.GeneralService;

public class CurrentInfoAboutThePlaneController extends GeneralController<CurrentInfoAboutThePlane> {

    private static final CurrentInfoAboutThePlaneService CURRENT_INFO_ABOUT_THE_PLANE_SERVICE = new CurrentInfoAboutThePlaneService();

    @Override
    public final GeneralService<CurrentInfoAboutThePlane> getService() {
        return CURRENT_INFO_ABOUT_THE_PLANE_SERVICE;
    }

}
