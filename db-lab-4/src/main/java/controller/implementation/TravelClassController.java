package controller.implementation;

import model.implementation.TravelClass;
import service.IGeneralService;
import service.implementation.GeneralService;
import service.implementation.TravelClassService;

public class TravelClassController extends GeneralController<TravelClass> {

    private final GeneralService<TravelClass> travelClassService = new TravelClassService();

    @Override
    public final IGeneralService<TravelClass> getService() {
        return travelClassService;
    }
}
