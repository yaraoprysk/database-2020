package service.implementation;

import DAO.IGeneralDAO;
import DAO.implementation.ScheduleDAO;
import model.implementation.Schedule;

public class ScheduleService extends GeneralService<Schedule> {
    private final IGeneralDAO<Schedule, Integer> scheduleDAOImplementation = new ScheduleDAO();

    @Override
    public final IGeneralDAO<Schedule, Integer> getDAO() {
        return scheduleDAOImplementation;
    }
}