package com.lab6.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.lab6.repository.AirportRepository;
import com.lab6.domain.implementation.Airport;

@Service
public class AirportService extends GeneralService<Airport> {

    @Autowired
    AirportRepository airportRepository;

    @Override
    public JpaRepository<Airport, Integer> getRepository() {
        return airportRepository;
    }

}
