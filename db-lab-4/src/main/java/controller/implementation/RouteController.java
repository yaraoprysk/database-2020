package controller.implementation;

import model.implementation.Route;
import service.IGeneralService;
import service.implementation.GeneralService;
import service.implementation.RouteService;

public class RouteController  extends GeneralController<Route> {

    private final GeneralService<Route> routeService = new RouteService();

    @Override
    public final IGeneralService<Route> getService() {
        return routeService;
    }
}


