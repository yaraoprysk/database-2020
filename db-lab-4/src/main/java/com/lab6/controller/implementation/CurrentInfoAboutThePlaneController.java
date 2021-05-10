package com.lab6.controller.implementation;

import com.lab6.domain.implementation.CurrentInfoAboutThePlane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lab6.service.IGeneralService;
import com.lab6.service.implementation.CurrentInfoAboutThePlaneService;

@RestController
@RequestMapping("current_info_about_the_plane")
public class CurrentInfoAboutThePlaneController extends GeneralController<CurrentInfoAboutThePlane> {

    @Autowired
    CurrentInfoAboutThePlaneService currentInfoAboutThePlaneService;

    @Override
    public final IGeneralService<CurrentInfoAboutThePlane> getService() {
        return currentInfoAboutThePlaneService;
    }

}