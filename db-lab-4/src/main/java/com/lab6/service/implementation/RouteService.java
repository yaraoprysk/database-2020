package com.lab6.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.lab6.repository.RouteRepository;
import com.lab6.domain.implementation.Route;

@Service
public class RouteService extends GeneralService<Route> {

    @Autowired
    RouteRepository routeRepository;

    @Override
    public JpaRepository<Route, Integer> getRepository() {
        return routeRepository;
    }

}
