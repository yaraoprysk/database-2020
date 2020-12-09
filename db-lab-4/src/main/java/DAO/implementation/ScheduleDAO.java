package DAO.implementation;

import model.implementation.Schedule;

public class ScheduleDAO extends GeneralDAO<Schedule> {
    public final Class<Schedule> getClazz() {
        return Schedule.class;

    }
}