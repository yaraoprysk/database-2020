package com.lab6.controller.implementation;

import com.lab6.domain.implementation.InfoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lab6.service.IGeneralService;
import com.lab6.service.implementation.InfoClientService;

@RestController
@RequestMapping("client_info")
public class InfoClientController extends GeneralController<InfoClient> {

    @Autowired
    InfoClientService infoClientService;

    @Override
    public final IGeneralService<InfoClient> getService() {
        return infoClientService;
    }
}
