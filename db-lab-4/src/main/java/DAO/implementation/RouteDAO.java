package DAO.implementation;

import DAO.IGeneralDAO;
import model.implementation.Route;
import persistance.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class RouteDAO implements IGeneralDAO<Route, Integer> {

    private static final String GET_ALL = "SELECT * FROM oprysk_db.route";
    private static final String GET_BY_ID = "SELECT * FROM oprysk_db.route WHERE id=?";
    private static final String CREATE = "INSERT oprysk_db.route "
            + "(id, speed_km_per_hour, destination_in_km) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE oprysk_db.route"
            + " SET speed_km_per_hour=?, destination_in_km=? WHERE id=?";
    private static final String DELETE = "DELETE FROM oprysk_db.route WHERE id=?";

    @Override
    public final List<Route> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<Route> routes = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    Integer speedKmPerHours = resultSet.getInt(2);
                    Integer destinationInKm = resultSet.getInt(3);
                    routes.add(new Route(id, speedKmPerHours, destinationInKm));
                }
            }
        }
        return routes;
    }

    @Override
    public final Route getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        Route route = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    Integer speedKmPerHours = resultSet.getInt(2);
                    Integer destinationInKm = resultSet.getInt(3);
                    route = new Route(foundId, speedKmPerHours, destinationInKm);
                }
            }
        }

        return route;
    }

    @Override
    public final int create(final Route entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setInt(2, entity.getSpeedKmPerHours());
            ps.setInt(3, entity.getDestinationInKm());
            return ps.executeUpdate();
        }
    }

    @Override
    public final int update(final Route entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setInt(1, entity.getSpeedKmPerHours());
            ps.setInt(2, entity.getDestinationInKm());
            ps.setInt(3, entity.getId());
            return ps.executeUpdate();
        }
    }

    @Override
    public final int delete(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(DELETE)) {
            ps.setInt(1, id);
            return ps.executeUpdate();
        }
    }
}

