package controller.implementation;

import model.implementation.Airport;
import service.IGeneralService;
import service.implementation.AirportService;
import service.implementation.GeneralService;

public class AirportController extends GeneralController<Airport> {

    private final GeneralService<Airport> airportService = new AirportService();

    @Override
    public final IGeneralService<Airport> getService() {
        return airportService;
    }
}
