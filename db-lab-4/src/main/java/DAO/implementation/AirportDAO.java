package DAO.implementation;

import DAO.IGeneralDAO;
import model.implementation.Airport;
import persistance.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class AirportDAO implements IGeneralDAO<Airport, Integer> {

    private static final String GET_ALL = "SELECT * FROM oprysk_db.airport";
    private static final String GET_BY_ID = "SELECT * FROM oprysk_db.airport WHERE id=?";
    private static final String CREATE = "INSERT oprysk_db.airport "
            + "(id, name, city) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE oprysk_db.airport"
            + " SET name=?, city=? WHERE id=?";
    private static final String DELETE = "DELETE FROM oprysk_db.airport WHERE id=?";

    @Override
    public final List<Airport> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<Airport> airports = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String city = resultSet.getString(3);
                    airports.add(new Airport(id, name, city));
                }
            }
        }
        return airports;
    }

    @Override
    public final Airport getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        Airport airport = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String city = resultSet.getString(3);
                    airport = new Airport(foundId, name, city);
                }
            }
        }

        return airport;
    }

    @Override
    public final int create(final Airport entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getName());
            ps.setString(3, entity.getCity());
            return ps.executeUpdate();
        }
    }

    @Override
    public final int update(final Airport entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getCity());
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