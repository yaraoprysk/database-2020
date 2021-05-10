package com.lab6.service.implementation;

import com.lab6.domain.implementation.Airline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.lab6.repository.AirlineRepository;


@Service
public class AirlineService extends GeneralService<Airline> {

    @Autowired
    AirlineRepository airlineRepository;

    @Override
    public JpaRepository<Airline, Integer> getRepository() {
        return airlineRepository;
    }

}
