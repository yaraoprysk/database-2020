package controller.implementation;

import model.implementation.Flight;
import service.implementation.FlightService;
import service.implementation.GeneralService;

public class FlightController extends GeneralController<Flight> {

    private static final FlightService FLIGHT_SERVICE = new FlightService();

    @Override
    public final GeneralService<Flight> getService() {
        return FLIGHT_SERVICE;
    }

}
