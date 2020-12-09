package service.implementation;

import DAO.IGeneralDAO;
import DAO.implementation.GeneralDAO;
import DAO.implementation.ScheduleDAO;
import model.implementation.Schedule;

public class ScheduleService extends GeneralService<Schedule> {
    private final GeneralDAO<Schedule> SCHEDULE_DAO = new ScheduleDAO();

    @Override
    public IGeneralDAO<Schedule> getDAO() {
        return SCHEDULE_DAO;
    }
}