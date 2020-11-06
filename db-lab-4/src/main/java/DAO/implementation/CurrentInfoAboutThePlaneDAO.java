package DAO.implementation;

import DAO.IGeneralDAO;
import model.implementation.CurrentInfoAboutThePlane;

import persistance.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class CurrentInfoAboutThePlaneDAO implements IGeneralDAO<CurrentInfoAboutThePlane, Integer> {

    private static final String GET_ALL = "SELECT * FROM oprysk_db.current_info_about_the_plane";
    private static final String GET_BY_ID = "SELECT * FROM oprysk_db.current_info_about_the_plane WHERE id=?";
    private static final String CREATE = "INSERT oprysk_db.current_info_about_the_plane"
            + "(id, airline_id, airport_id, registration_info_id, flight_id, route_id, schedule_id, plane_info_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE oprysk_db.current_info_about_the_plane"
            + " SET airline_id=?, airport_id=?,registration_info_id=?, flight_id=?, route_id=?, schedule_id=?, plane_info_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM oprysk_db.current_info_about_the_plane WHERE id=?";

    @Override
    public final List<CurrentInfoAboutThePlane> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<CurrentInfoAboutThePlane> currentInfoAboutThePlanes = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    Integer airlineId = resultSet.getInt(2);
                    Integer airportId = resultSet.getInt(3);
                    Integer registrationInfoId = resultSet.getInt(4);
                    Integer flightId = resultSet.getInt(5);
                    Integer routeId = resultSet.getInt(6);
                    Integer scheduleId = resultSet.getInt(7);
                    Integer planeInfoId = resultSet.getInt(8);
                    currentInfoAboutThePlanes.add(new CurrentInfoAboutThePlane(id, airlineId, airportId,
                            registrationInfoId, flightId, routeId,scheduleId, planeInfoId));
                }
            }
        }
        return currentInfoAboutThePlanes;
    }

    @Override
    public final CurrentInfoAboutThePlane getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        CurrentInfoAboutThePlane currentInfoAboutThePlane = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    Integer airlineId = resultSet.getInt(2);
                    Integer airportId = resultSet.getInt(3);
                    Integer registrationInfoId = resultSet.getInt(4);
                    Integer flightId = resultSet.getInt(5);
                    Integer routeId = resultSet.getInt(6);
                    Integer scheduleId = resultSet.getInt(7);
                    Integer planeInfoId = resultSet.getInt(8);
                    currentInfoAboutThePlane = new CurrentInfoAboutThePlane(foundId, airlineId, airportId, registrationInfoId,
                            flightId, routeId, scheduleId, planeInfoId);
                }
            }
        }

        return currentInfoAboutThePlane;
    }

    @Override
    public final int create(final CurrentInfoAboutThePlane entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setInt(2, entity.getAirlineId());
            ps.setInt(3, entity.getAirportId());
            ps.setInt(4, entity.getRegistrationInfoId());
            ps.setInt(5, entity.getFlightId());
            ps.setInt(6, entity.getRouteId());
            ps.setInt(7, entity.getScheduleId());
            ps.setInt(8, entity.getPlaneInfoId());
            return ps.executeUpdate();
        }
    }

    @Override
    public final int update(final CurrentInfoAboutThePlane entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setInt(1, entity.getAirlineId());
            ps.setInt(2, entity.getAirportId());
            ps.setInt(3, entity.getRegistrationInfoId());
            ps.setInt(4, entity.getFlightId());
            ps.setInt(5, entity.getRouteId());
            ps.setInt(6, entity.getScheduleId());
            ps.setInt(7, entity.getPlaneInfoId());
            ps.setInt(8, entity.getId());
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

