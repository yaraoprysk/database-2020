package service.implementation;

import DAO.IGeneralDAO;
import DAO.implementation.RouteDAO;
import model.implementation.Route;

public class RouteService extends GeneralService<Route> {
    private final IGeneralDAO<Route, Integer> routeDAOImplementation = new RouteDAO();

    @Override
    public final IGeneralDAO<Route, Integer> getDAO() {
        return routeDAOImplementation;
    }
}