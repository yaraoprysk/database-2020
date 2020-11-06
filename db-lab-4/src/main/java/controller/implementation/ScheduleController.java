package controller.implementation;

import model.implementation.Schedule;
import service.implementation.GeneralService;
import service.implementation.ScheduleService;

public class ScheduleController extends GeneralController<Schedule> {

    private static final ScheduleService SCHEDULE_SERVICE = new ScheduleService();

    @Override
    public final GeneralService<Schedule> getService() {
        return SCHEDULE_SERVICE;
    }

}

