package com.lab6.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.lab6.repository.InfoClientRepository;
import com.lab6.domain.implementation.InfoClient;

@Service
public class InfoClientService extends GeneralService<InfoClient> {

    @Autowired
    InfoClientRepository infoClientRepository;

    @Override
    public JpaRepository<InfoClient, Integer> getRepository() {
        return infoClientRepository;
    }

}
