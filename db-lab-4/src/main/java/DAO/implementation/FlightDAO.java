package DAO.implementation;

import DAO.IGeneralDAO;
import model.implementation.Flight;
import persistance.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class FlightDAO implements IGeneralDAO<Flight, Integer> {

    private static final String GET_ALL = "SELECT * FROM oprysk_db.flight";
    private static final String GET_BY_ID = "SELECT * FROM oprysk_db.flight WHERE id=?";
    private static final String CREATE = "INSERT oprysk_db.flight"
            + "(id, departure_point, destination) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE oprysk_db.flight"
            + " SET departure_point=?, destination=?  WHERE id=?";
    private static final String DELETE = "DELETE FROM oprysk_db.flight WHERE id=?";

    @Override
    public final List<Flight> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<Flight> flights = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    String departurePoint = resultSet.getString(2);
                    String destination = resultSet.getString(3);
                    flights.add(new Flight(id, departurePoint, destination));
                }
            }
        }
        return flights;
    }

    @Override
    public final Flight getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        Flight flight = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    String departurePoint = resultSet.getString(2);
                    String destination = resultSet.getString(3);
                    flight = new Flight(foundId, departurePoint, destination);
                }
            }
        }

        return flight;
    }

    @Override
    public final int create(final Flight entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getDeparturePoint());
            ps.setString(3, entity.getDestination());
            return ps.executeUpdate();
        }
    }

    @Override
    public final int update(final Flight entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, entity.getDeparturePoint());
            ps.setString(2, entity.getDestination());
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
