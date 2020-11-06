package DAO.implementation;

import DAO.IGeneralDAO;
import model.implementation.InfoClient;
import persistance.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class InfoClientDAO implements IGeneralDAO<InfoClient, Integer> {

    private static final String GET_ALL = "SELECT * FROM oprysk_db.client_info";
    private static final String GET_BY_ID = "SELECT * FROM oprysk_db.client_info WHERE id=?";
    private static final String CREATE = "INSERT oprysk_db.client_info"
            + "(id, first_name, middle_name, last_name, phone, email, passport) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE oprysk_db.client_info"
            + " SET first_name=?, middle_name=?,last_name=?, phone=?, email=?, passport=? WHERE id=?";
    private static final String DELETE = "DELETE FROM oprysk_db.client_info WHERE id=?";

    @Override
    public final List<InfoClient> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<InfoClient> infoClients = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    String firstName = resultSet.getString(2);
                    String middleName = resultSet.getString(3);
                    String lastName = resultSet.getString(4);
                    String phone = resultSet.getString(5);
                    String email = resultSet.getString(6);
                    String passport = resultSet.getString(7);
                    infoClients.add(new InfoClient(id, firstName, middleName, lastName, phone, email, passport));
                }
            }
        }
        return infoClients;
    }

    @Override
    public final InfoClient getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        InfoClient infoClient = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    String firstName = resultSet.getString(2);
                    String middleName = resultSet.getString(3);
                    String lastName = resultSet.getString(4);
                    String phone = resultSet.getString(5);
                    String email = resultSet.getString(6);
                    String passport = resultSet.getString(7);
                    infoClient = new InfoClient(foundId, firstName, middleName, lastName, phone, email, passport);
                }
            }
        }

        return infoClient;
    }

    @Override
    public final int create(final InfoClient entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getFirstName());
            ps.setString(3, entity.getMiddleName());
            ps.setString(4, entity.getLastName());
            ps.setString(5, entity.getPhone());
            ps.setString(6, entity.getEmail());
            ps.setString(7, entity.getPassport());
            return ps.executeUpdate();
        }
    }

    @Override
    public final int update(final InfoClient entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, entity.getFirstName());
            ps.setString(2, entity.getMiddleName());
            ps.setString(3, entity.getLastName());
            ps.setString(4, entity.getPhone());
            ps.setString(5, entity.getEmail());
            ps.setString(6, entity.getPassport());
            ps.setInt(7, entity.getId());
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

