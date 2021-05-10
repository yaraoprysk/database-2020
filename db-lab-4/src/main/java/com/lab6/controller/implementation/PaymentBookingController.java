package com.lab6.controller.implementation;

import com.lab6.domain.implementation.PaymentBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lab6.service.IGeneralService;
import com.lab6.service.implementation.PaymentBookingService;

@RestController
@RequestMapping("payment_booking")
public class PaymentBookingController extends GeneralController<PaymentBooking> {

    @Autowired
    PaymentBookingService paymentBookingService;

    @Override
    public final IGeneralService<PaymentBooking> getService() {
        return paymentBookingService;
    }
}
