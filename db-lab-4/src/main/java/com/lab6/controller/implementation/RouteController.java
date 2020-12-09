package com.lab6.controller.implementation;

import com.lab6.domain.implementation.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lab6.service.IGeneralService;
import com.lab6.service.implementation.RouteService;

@RestController
@RequestMapping("route")
public class RouteController  extends GeneralController<Route> {

    @Autowired
    RouteService routeService;

    @Override
    public final IGeneralService<Route> getService() {
        return routeService;
    }
}


