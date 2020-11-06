package controller.implementation;

import model.implementation.Airport;
import service.implementation.AirportService;
import service.implementation.GeneralService;

public class AirportController extends GeneralController<Airport> {

    private static final AirportService AIRPORT_SERVICE = new AirportService();

    @Override
    public final GeneralService<Airport> getService() {
        return AIRPORT_SERVICE;
    }

}
