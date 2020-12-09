package com.lab6.controller.implementation;

import com.lab6.domain.implementation.PlaneInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lab6.service.IGeneralService;
import com.lab6.service.implementation.PlaneInfoService;

@RestController
@RequestMapping("plane_info")
public class PlaneInfoController extends GeneralController<PlaneInfo> {

    @Autowired
    PlaneInfoService planeInfoService;

    @Override
    public final IGeneralService<PlaneInfo> getService() {
        return planeInfoService;
    }
}

