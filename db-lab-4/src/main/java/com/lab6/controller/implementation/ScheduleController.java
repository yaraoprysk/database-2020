package com.lab6.controller.implementation;

import com.lab6.domain.implementation.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lab6.service.IGeneralService;
import com.lab6.service.implementation.ScheduleService;

@RestController
@RequestMapping("schedule")
public class ScheduleController extends GeneralController<Schedule> {

    @Autowired
    ScheduleService scheduleService;

    @Override
    public final IGeneralService<Schedule> getService() {
        return scheduleService;
    }
}
