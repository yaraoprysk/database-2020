package com.lab6.controller.implementation;

import com.lab6.domain.implementation.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lab6.service.IGeneralService;
import com.lab6.service.implementation.BookingService;

@RestController
@RequestMapping("booking")
public class BookingController extends GeneralController<Booking> {

    @Autowired
    BookingService bookingService;

    @Override
    public final IGeneralService<Booking> getService() {
        return bookingService;
    }
}
