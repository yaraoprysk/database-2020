package com.lab6.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.lab6.repository.PaymentBookingRepository;
import com.lab6.domain.implementation.PaymentBooking;

@Service
public class PaymentBookingService extends GeneralService<PaymentBooking> {

    @Autowired
    PaymentBookingRepository paymentBookingRepository;

    @Override
    public JpaRepository<PaymentBooking, Integer> getRepository() {
        return paymentBookingRepository;
    }

}

