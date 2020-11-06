package controller.implementation;

import model.implementation.Airline;
import service.implementation.AirlineService;
import service.implementation.GeneralService;

public class AirlineController extends GeneralController<Airline> {
    private static final AirlineService AIRLINE_SERVICE = new AirlineService();

    @Override
    public final GeneralService<Airline> getService() {
        return AIRLINE_SERVICE;
    }
}
