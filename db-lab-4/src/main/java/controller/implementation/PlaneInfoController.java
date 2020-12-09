package controller.implementation;

import model.implementation.PlaneInfo;
import service.IGeneralService;
import service.implementation.GeneralService;
import service.implementation.PlaneInfoService;

public class PlaneInfoController extends GeneralController<PlaneInfo> {

    private final GeneralService<PlaneInfo> planeInfoService = new PlaneInfoService();

    @Override
    public final IGeneralService<PlaneInfo> getService() {
        return planeInfoService;
    }
}

