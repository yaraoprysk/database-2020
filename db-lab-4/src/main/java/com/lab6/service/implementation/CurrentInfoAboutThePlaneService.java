package com.lab6.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.lab6.repository.CurrentInfoAboutThePlaneRepository;
import com.lab6.domain.implementation.CurrentInfoAboutThePlane;

@Service
public class CurrentInfoAboutThePlaneService extends GeneralService<CurrentInfoAboutThePlane> {

    @Autowired
    CurrentInfoAboutThePlaneRepository currentInfoAboutThePlaneRepository;

    @Override
    public JpaRepository<CurrentInfoAboutThePlane, Integer> getRepository() {
        return currentInfoAboutThePlaneRepository;
    }

}
