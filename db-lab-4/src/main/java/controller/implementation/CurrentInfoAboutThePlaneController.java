package controller.implementation;

import model.implementation.CurrentInfoAboutThePlane;
import service.IGeneralService;
import service.implementation.CurrentInfoAboutThePlaneService;
import service.implementation.GeneralService;

public class CurrentInfoAboutThePlaneController extends GeneralController<CurrentInfoAboutThePlane> {

    private final GeneralService<CurrentInfoAboutThePlane> currentInfoAboutThePlaneService = new CurrentInfoAboutThePlaneService();

    @Override
    public final IGeneralService<CurrentInfoAboutThePlane> getService() {
        return currentInfoAboutThePlaneService;
    }

}