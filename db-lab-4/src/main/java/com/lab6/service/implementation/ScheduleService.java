package com.lab6.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.lab6.repository.ScheduleRepository;
import com.lab6.domain.implementation.Schedule;

@Service
public class ScheduleService extends GeneralService<Schedule> {

    @Autowired
    ScheduleRepository scheduleRepository;

    @Override
    public JpaRepository<Schedule, Integer> getRepository() {
        return scheduleRepository;
    }

}
