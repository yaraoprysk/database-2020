package com.lab6.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.lab6.repository.PlaneInfoRepository;
import com.lab6.domain.implementation.PlaneInfo;

@Service
public class PlaneInfoService extends GeneralService<PlaneInfo> {

    @Autowired
    PlaneInfoRepository planeInfoRepository;

    @Override
    public JpaRepository<PlaneInfo, Integer> getRepository() {
        return planeInfoRepository;
    }

}



