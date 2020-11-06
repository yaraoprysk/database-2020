package DAO.implementation;

import DAO.IGeneralDAO;
import model.implementation.Airline;
import persistance.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class AirlineDAO implements IGeneralDAO<Airline, Integer> {

    private static final String GET_ALL = "SELECT * FROM oprysk_db.airline";
    private static final String GET_BY_ID = "SELECT * FROM oprysk_db.airline WHERE id=?";
    private static final String CREATE = "INSERT oprysk_db.airline "
            + "(id, name, country) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE oprysk_db.airline"
            + " SET name=?, country=? WHERE id=?";
    private static final String DELETE = "DELETE FROM oprysk_db.airline WHERE id=?";

    @Override
    public final List<Airline> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<Airline> airlines = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String country = resultSet.getString(3);
                    airlines.add(new Airline(id, name, country));
                }
            }
        }
        return airlines;
    }

    @Override
    public final Airline getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        Airline airline = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String country = resultSet.getString(3);
                    airline = new Airline(foundId, name, country);
                }
            }
        }

        return airline;
    }

    @Override
    public final int create(final Airline entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getName());
            ps.setString(3, entity.getCountry());
            return ps.executeUpdate();
        }
    }

    @Override
    public final int update(final Airline entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getCountry());
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
