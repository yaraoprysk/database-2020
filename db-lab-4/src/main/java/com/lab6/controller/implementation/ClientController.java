package com.lab6.controller.implementation;

import com.lab6.domain.implementation.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lab6.service.IGeneralService;
import com.lab6.service.implementation.ClientService;


@RestController
@RequestMapping("client")
public class ClientController extends GeneralController<Client> {

    @Autowired
    ClientService clientService;

    @Override
    public final IGeneralService<Client> getService() {
        return clientService;
    }
}

