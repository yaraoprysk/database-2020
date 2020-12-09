package service;

import DAO.IGeneralDAO;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public interface IGeneralService<T> {
    IGeneralDAO<T> getDAO();

    List<T> getAll(Session session) throws SQLException;

    T getById(Integer id, Session session) throws SQLException;

    void create(T entity, Session session) throws SQLException;
    void update(T entity, Session session) throws SQLException;

    void delete(Integer id, Session session) throws SQLException;

}