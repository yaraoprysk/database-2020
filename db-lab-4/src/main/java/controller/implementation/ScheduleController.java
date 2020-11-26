package controller.implementation;

import model.implementation.Schedule;
import service.IGeneralService;
import service.implementation.GeneralService;
import service.implementation.ScheduleService;

public class ScheduleController extends GeneralController<Schedule> {

    private final GeneralService<Schedule> scheduleService = new ScheduleService();

    @Override
    public final IGeneralService<Schedule> getService() {
        return scheduleService;
    }
}
