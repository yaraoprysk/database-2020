package DAO.implementation;

import DAO.IGeneralDAO;
import model.implementation.TravelClass;
import persistance.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class TravelClassDAO implements IGeneralDAO<TravelClass, Integer> {

    private static final String GET_ALL = "SELECT * FROM oprysk_db.travel_class";
    private static final String GET_BY_ID = "SELECT * FROM oprysk_db.travel_class WHERE id=?";
    private static final String CREATE = "INSERT oprysk_db.travel_class"
            + "(id, name) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE oprysk_db.travel_class"
            + " SET name=?  WHERE id=?";
    private static final String DELETE = "DELETE FROM oprysk_db.travel_class WHERE id=?";

    @Override
    public final List<TravelClass> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<TravelClass> travelClasses = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    travelClasses.add(new TravelClass(id, name));
                }
            }
        }
        return travelClasses;
    }

    @Override
    public final TravelClass getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        TravelClass travelClass = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    travelClass = new TravelClass(foundId, name);
                }
            }
        }

        return travelClass;
    }

    @Override
    public final int create(final TravelClass entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getName());
            return ps.executeUpdate();
        }
    }

    @Override
    public final int update(final TravelClass entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, entity.getName());
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

