package com.lab6.controller.implementation;

import com.lab6.domain.implementation.TravelClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lab6.service.IGeneralService;
import com.lab6.service.implementation.TravelClassService;

@RestController
@RequestMapping("travel_class")
public class TravelClassController extends GeneralController<TravelClass> {

    @Autowired
    TravelClassService travelClassService;

    @Override
    public final IGeneralService<TravelClass> getService() {
        return travelClassService;
    }
}
