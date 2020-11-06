package DAO.implementation;

import DAO.IGeneralDAO;
import model.implementation.PaymentBooking;
import persistance.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class PaymentBookingDAO implements IGeneralDAO<PaymentBooking, Integer> {

    private static final String GET_ALL = "SELECT * FROM oprysk_db.payment_booking";
    private static final String GET_BY_ID = "SELECT * FROM oprysk_db.payment_booking WHERE id=?";
    private static final String CREATE = "INSERT oprysk_db.payment_booking"
            + "(id, status) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE oprysk_db.payment_booking"
            + " SET status=?  WHERE id=?";
    private static final String DELETE = "DELETE FROM oprysk_db.payment_booking WHERE id=?";

    @Override
    public final List<PaymentBooking> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<PaymentBooking> paymentBookings = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    String status = resultSet.getString(2);
                    paymentBookings.add(new PaymentBooking(id, status));
                }
            }
        }
        return paymentBookings;
    }

    @Override
    public final PaymentBooking getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        PaymentBooking paymentBooking = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    String status = resultSet.getString(2);
                    paymentBooking = new PaymentBooking(foundId, status);
                }
            }
        }

        return paymentBooking;
    }

    @Override
    public final int create(final PaymentBooking entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getStatus());
            return ps.executeUpdate();
        }
    }

    @Override
    public final int update(final PaymentBooking entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, entity.getStatus());
            ps.setInt(2, entity.getId());
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
