package com.lab6.controller.implementation;

import com.lab6.domain.implementation.RegistrationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lab6.service.IGeneralService;
import com.lab6.service.implementation.RegistrationInfoService;

@RestController
@RequestMapping("registration_info")
public class RegistrationInfoController extends GeneralController<RegistrationInfo> {

    @Autowired
    RegistrationInfoService registrationInfoService;

    @Override
    public final IGeneralService<RegistrationInfo> getService() {
        return registrationInfoService;
    }
}

