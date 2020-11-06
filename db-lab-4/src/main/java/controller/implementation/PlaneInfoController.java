package controller.implementation;

import model.implementation.PlaneInfo;
import service.implementation.GeneralService;
import service.implementation.PlaneInfoService;

public class PlaneInfoController extends GeneralController<PlaneInfo> {

    private static final PlaneInfoService PLANE_INFO_SERVICE = new PlaneInfoService();

    @Override
    public final GeneralService<PlaneInfo> getService() {
        return PLANE_INFO_SERVICE;
    }

}
