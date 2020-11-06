package DAO.implementation;

import DAO.IGeneralDAO;
import model.implementation.Booking;
import persistance.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class BookingDAO implements IGeneralDAO<Booking, Integer> {

    private static final String GET_ALL = "SELECT * FROM oprysk_db.booking";
    private static final String GET_BY_ID = "SELECT * FROM oprysk_db.booking WHERE id=?";
    private static final String CREATE = "INSERT oprysk_db.booking "
            + "(id, airline_id, travel_class_id, ticket_id, plane_info_id) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE oprysk_db.booking"
            + " SET airline_id=?, travel_class_id=?,ticket_id=?, plane_info_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM oprysk_db.booking WHERE id=?";

    @Override
    public final List<Booking> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<Booking> bookings = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    Integer airlineId = resultSet.getInt(2);
                    Integer travelClassId = resultSet.getInt(3);
                    Integer ticketId = resultSet.getInt(4);
                    Integer planeInfoId = resultSet.getInt(5);
                    bookings.add(new Booking(id, airlineId, travelClassId, ticketId, planeInfoId));
                }
            }
        }
        return bookings;
    }

    @Override
    public final Booking getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        Booking booking = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    Integer airlineId = resultSet.getInt(2);
                    Integer travelClassId = resultSet.getInt(3);
                    Integer ticketId = resultSet.getInt(4);
                    Integer planeInfoId = resultSet.getInt(5);
                    booking = new Booking(foundId, airlineId, travelClassId, ticketId, planeInfoId);
                }
            }
        }

        return booking;
    }

    @Override
    public final int create(final Booking entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setInt(2, entity.getAirlineId());
            ps.setInt(3, entity.getTravelClassId());
            ps.setInt(4, entity.getTicketId());
            ps.setInt(5, entity.getPlaneInfoId());
            return ps.executeUpdate();
        }
    }

    @Override
    public final int update(final Booking entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setInt(1, entity.getAirlineId());
            ps.setInt(2, entity.getTravelClassId());
            ps.setInt(3, entity.getTicketId());
            ps.setInt(4, entity.getPlaneInfoId());
            ps.setInt(5, entity.getId());
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