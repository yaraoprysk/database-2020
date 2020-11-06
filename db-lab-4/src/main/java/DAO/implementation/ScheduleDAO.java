package DAO.implementation;

import DAO.IGeneralDAO;
import model.implementation.Schedule;
import persistance.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ScheduleDAO implements IGeneralDAO<Schedule, Integer> {

    private static final String GET_ALL = "SELECT * FROM oprysk_db.schedule";
    private static final String GET_BY_ID = "SELECT * FROM oprysk_db.schedule WHERE id=?";
    private static final String CREATE = "INSERT oprysk_db.schedule"
            + "(id, arrival_time, departure_time) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE oprysk_db.schedule"
            + " SET arrival_time=?, departure_time=?  WHERE id=?";
    private static final String DELETE = "DELETE FROM oprysk_db.schedule WHERE id=?";

    @Override
    public final List<Schedule> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<Schedule> schedules = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    String arrivalTime = resultSet.getString(2);
                    String departureTime = resultSet.getString(3);
                    schedules.add(new Schedule(id, arrivalTime, departureTime));
                }
            }
        }
        return schedules;
    }

    @Override
    public final Schedule getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        Schedule schedule = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    String arrivalTime = resultSet.getString(2);
                    String departureTime = resultSet.getString(3);
                    schedule = new Schedule(foundId, arrivalTime, departureTime);
                }
            }
        }

        return schedule;
    }

    @Override
    public final int create(final Schedule entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getArrivalTime());
            ps.setString(3, entity.getDepartureTime());
            return ps.executeUpdate();
        }
    }

    @Override
    public final int update(final Schedule entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, entity.getArrivalTime());
            ps.setString(2, entity.getDepartureTime());
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
