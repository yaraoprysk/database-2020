package com.lab6.controller.implementation;

import com.lab6.domain.implementation.Airline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lab6.service.IGeneralService;
import com.lab6.service.implementation.AirlineService;



@RestController
@RequestMapping("airline")
public class AirlineController extends GeneralController<Airline> {

    @Autowired
    AirlineService airlineService;

    @Override
    public final IGeneralService<Airline> getService() {
        return airlineService;
    }
}
