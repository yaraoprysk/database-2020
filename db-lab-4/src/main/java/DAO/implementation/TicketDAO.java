package DAO.implementation;

import DAO.IGeneralDAO;
import model.implementation.Ticket;
import persistance.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class TicketDAO implements IGeneralDAO<Ticket, Integer> {

    private static final String GET_ALL = "SELECT * FROM oprysk_db.ticket";
    private static final String GET_BY_ID = "SELECT * FROM oprysk_db.ticket WHERE id=?";
    private static final String CREATE = "INSERT oprysk_db.ticket "
            + "(id, price, payment_booking_id) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE oprysk_db.ticket"
            + " SET price=?, payment_booking_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM oprysk_db.ticket WHERE id=?";

    @Override
    public final List<Ticket> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<Ticket> tickets = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    Integer price = resultSet.getInt(2);
                    Integer paymentBookingId = resultSet.getInt(3);
                    tickets.add(new Ticket(id, price, paymentBookingId));
                }
            }
        }
        return tickets;
    }

    @Override
    public final Ticket getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        Ticket ticket = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    Integer price = resultSet.getInt(2);
                    Integer paymentBookingId = resultSet.getInt(3);
                    ticket = new Ticket(foundId, price, paymentBookingId);
                }
            }
        }

        return ticket;
    }

    @Override
    public final int create(final Ticket entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setInt(2, entity.getPrice());
            ps.setInt(3, entity.getPaymentBookingId());
            return ps.executeUpdate();
        }
    }

    @Override
    public final int update(final Ticket entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setInt(1, entity.getPrice());
            ps.setInt(2, entity.getPaymentBookingId());
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

