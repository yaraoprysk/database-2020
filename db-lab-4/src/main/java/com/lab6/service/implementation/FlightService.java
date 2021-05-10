package com.lab6.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.lab6.repository.FlightRepository;
import com.lab6.domain.implementation.Flight;


@Service
public class FlightService extends GeneralService<Flight> {

    @Autowired
    FlightRepository flightRepository;

    @Override
    public JpaRepository<Flight, Integer> getRepository() {
        return flightRepository;
    }

}
