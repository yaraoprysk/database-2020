package controller.implementation;

import model.implementation.Route;
import service.implementation.GeneralService;
import service.implementation.RouteService;

public class RouteController  extends GeneralController<Route> {

    private static final RouteService ROUTE_SERVICE = new RouteService();

    @Override
    public final GeneralService<Route> getService() {
        return ROUTE_SERVICE;
    }

}

