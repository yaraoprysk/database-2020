package DAO.implementation;

import DAO.IGeneralDAO;
import model.implementation.PlaneInfo;
import persistance.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class PlaneInfoDAO implements IGeneralDAO<PlaneInfo, Integer> {

    private static final String GET_ALL = "SELECT * FROM oprysk_db.plane_info";
    private static final String GET_BY_ID = "SELECT * FROM oprysk_db.plane_info WHERE id=?";
    private static final String CREATE = "INSERT oprysk_db.plane_info "
            + "(id, number_seats, status) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE oprysk_db.plane_info"
            + " SET number_seats=?, status=? WHERE id=?";
    private static final String DELETE = "DELETE FROM oprysk_db.plane_info WHERE id=?";

    @Override
    public final List<PlaneInfo> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<PlaneInfo> planeInfos = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    Integer numberSeats = resultSet.getInt(2);
                    String status = resultSet.getString(3);
                    planeInfos.add(new PlaneInfo(id, numberSeats, status));
                }
            }
        }
        return planeInfos;
    }

    @Override
    public final PlaneInfo getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        PlaneInfo planeInfo = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    Integer numberSeats = resultSet.getInt(2);
                    String status = resultSet.getString(3);
                    planeInfo = new PlaneInfo(foundId, numberSeats, status);
                }
            }
        }

        return planeInfo;
    }

    @Override
    public final int create(final PlaneInfo entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setInt(2, entity.getNumberSeats());
            ps.setString(3, entity.getStatus());
            return ps.executeUpdate();
        }
    }

    @Override
    public final int update(final PlaneInfo entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setInt(1, entity.getNumberSeats());
            ps.setString(2, entity.getStatus());
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
