package com.lab6.controller.implementation;

import com.lab6.domain.implementation.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lab6.service.IGeneralService;
import com.lab6.service.implementation.FlightService;



@RestController
@RequestMapping("flight")
public class FlightController extends GeneralController<Flight> {

    @Autowired
    FlightService flightService;

    @Override
    public final IGeneralService<Flight> getService() {
        return flightService;
    }
}

