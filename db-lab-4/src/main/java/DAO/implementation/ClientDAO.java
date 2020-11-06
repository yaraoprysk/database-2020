package DAO.implementation;

import DAO.IGeneralDAO;
import model.implementation.Client;
import persistance.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ClientDAO implements IGeneralDAO<Client, Integer> {

    private static final String GET_ALL = "SELECT * FROM oprysk_db.client";
    private static final String GET_BY_ID = "SELECT * FROM oprysk_db.client WHERE id=?";
    private static final String CREATE = "INSERT oprysk_db.client"
            + "(id, current_info_about_the_plane_id, booking_id, ticket_id, client_info_id) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE oprysk_db.client"
            + " SET current_info_about_the_plane_id=?, booking_id=?,ticket_id=?, client_info_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM oprysk_db.client WHERE id=?";

    @Override
    public final List<Client> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<Client> clients = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    Integer currentInfoAboutThePlaneId = resultSet.getInt(2);
                    Integer bookingId = resultSet.getInt(3);
                    Integer ticketId = resultSet.getInt(4);
                    Integer infoClientId = resultSet.getInt(5);
                    clients.add(new Client(id, currentInfoAboutThePlaneId, bookingId, ticketId, infoClientId));
                }
            }
        }
        return clients;
    }

    @Override
    public final Client getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        Client client = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    Integer currentInfoAboutThePlaneId = resultSet.getInt(2);
                    Integer bookingId = resultSet.getInt(3);
                    Integer ticketId = resultSet.getInt(4);
                    Integer infoClientId = resultSet.getInt(5);
                    client = new Client(foundId, currentInfoAboutThePlaneId, bookingId, ticketId, infoClientId);
                }
            }
        }

        return client;
    }

    @Override
    public final int create(final Client entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setInt(2, entity.getCurrentInfoAboutThePlaneId());
            ps.setInt(3, entity.getBookingId());
            ps.setInt(4, entity.getTicketId());
            ps.setInt(5, entity.getInfoClientId());
            return ps.executeUpdate();
        }
    }

    @Override
    public final int update(final Client entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setInt(1, entity.getCurrentInfoAboutThePlaneId());
            ps.setInt(2, entity.getBookingId());
            ps.setInt(3, entity.getTicketId());
            ps.setInt(4, entity.getInfoClientId());
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
