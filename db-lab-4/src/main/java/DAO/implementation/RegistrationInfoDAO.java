package DAO.implementation;

import DAO.IGeneralDAO;
import model.implementation.RegistrationInfo;
import persistance.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class RegistrationInfoDAO implements IGeneralDAO<RegistrationInfo, Integer> {

    private static final String GET_ALL = "SELECT * FROM oprysk_db.registration_info";
    private static final String GET_BY_ID = "SELECT * FROM oprysk_db.registration_info WHERE id=?";
    private static final String CREATE = "INSERT oprysk_db.registration_info "
            + "(id, manufacture_year, general_plaque_hours, model, board_number) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE oprysk_db.registration_info"
            + " SET manufacture_year=?, general_plaque_hours=?,model=?, board_number=? WHERE id=?";
    private static final String DELETE = "DELETE FROM oprysk_db.registration_info WHERE id=?";

    @Override
    public final List<RegistrationInfo> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<RegistrationInfo> registrationInfos = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    Integer manufactureYear = resultSet.getInt(2);
                    Integer generalPlaqueHours = resultSet.getInt(3);
                    String model = resultSet.getString(4);
                    String boardNumber = resultSet.getString(5);
                    registrationInfos.add(new RegistrationInfo(id, manufactureYear, generalPlaqueHours, model, boardNumber));
                }
            }
        }
        return registrationInfos;
    }

    @Override
    public final RegistrationInfo getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        RegistrationInfo registrationInfo = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    Integer manufactureYear = resultSet.getInt(2);
                    Integer generalPlaqueHours = resultSet.getInt(3);
                    String model = resultSet.getString(4);
                    String boardNumber = resultSet.getString(5);
                    registrationInfo = new RegistrationInfo(foundId, manufactureYear, generalPlaqueHours, model, boardNumber);
                }
            }
        }

        return registrationInfo;
    }

    @Override
    public final int create(final RegistrationInfo entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setInt(2, entity.getManufactureYear());
            ps.setInt(3, entity.getGeneralPlaqueHours());
            ps.setString(4, entity.getModel());
            ps.setString(5, entity.getBoardNumber());
            return ps.executeUpdate();
        }
    }

    @Override
    public final int update(final RegistrationInfo entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setInt(1, entity.getManufactureYear());
            ps.setInt(2, entity.getGeneralPlaqueHours());
            ps.setString(3, entity.getModel());
            ps.setString(4, entity.getBoardNumber());
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