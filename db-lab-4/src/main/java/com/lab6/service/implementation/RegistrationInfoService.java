package com.lab6.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.lab6.repository.RegistrationInfoRepository;
import com.lab6.domain.implementation.RegistrationInfo;

@Service
public class RegistrationInfoService extends GeneralService<RegistrationInfo> {

    @Autowired
    RegistrationInfoRepository registrationInfoRepository;

    @Override
    public JpaRepository<RegistrationInfo, Integer> getRepository() {
        return registrationInfoRepository;
    }

}
