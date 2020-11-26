package service.implementation;

import DAO.IGeneralDAO;
import DAO.implementation.GeneralDAO;
import DAO.implementation.RouteDAO;
import model.implementation.Route;

public class RouteService extends GeneralService<Route> {
    private final GeneralDAO<Route> ROUTE_DAO = new RouteDAO();

    @Override
    public IGeneralDAO<Route> getDAO() {
        return ROUTE_DAO;
    }
}