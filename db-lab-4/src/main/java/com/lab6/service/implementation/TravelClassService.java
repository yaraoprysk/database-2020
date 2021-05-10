package com.lab6.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.lab6.repository.TravelClassRepository;
import com.lab6.domain.implementation.TravelClass;

@Service
public class TravelClassService extends GeneralService<TravelClass> {

    @Autowired
    TravelClassRepository travelClassRepository;

    @Override
    public JpaRepository<TravelClass, Integer> getRepository() {
        return travelClassRepository;
    }

}
