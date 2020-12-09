package controller.implementation;

import model.implementation.Flight;
import service.IGeneralService;
import service.implementation.FlightService;
import service.implementation.GeneralService;

public class FlightController extends GeneralController<Flight> {

    private final GeneralService<Flight> flightService = new FlightService();

    @Override
    public final IGeneralService<Flight> getService() {
        return flightService;
    }
}

