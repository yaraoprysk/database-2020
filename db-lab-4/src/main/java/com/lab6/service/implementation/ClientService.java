package com.lab6.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.lab6.repository.ClientRepository;
import com.lab6.domain.implementation.Client;

@Service
public class ClientService extends GeneralService<Client> {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public JpaRepository<Client, Integer> getRepository() {
        return clientRepository;
    }

}
