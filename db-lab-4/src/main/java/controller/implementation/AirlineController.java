package controller.implementation;

import model.implementation.Airline;
import service.IGeneralService;
import service.implementation.AirlineService;
import service.implementation.GeneralService;

public class AirlineController extends GeneralController<Airline> {
    private final GeneralService<Airline> airlineService = new AirlineService();

    @Override
    public final IGeneralService<Airline> getService() {
        return airlineService;
    }
}
