package controller.implementation;

import model.implementation.TravelClass;
import service.implementation.GeneralService;
import service.implementation.TravelClassService;

public class TravelClassController extends GeneralController<TravelClass> {

    private static final TravelClassService TRAVEL_CLASS_SERVICE = new TravelClassService();

    @Override
    public final GeneralService<TravelClass> getService() {
        return TRAVEL_CLASS_SERVICE;
    }

}