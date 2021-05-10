package com.lab6.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.lab6.repository.BookingRepository;
import com.lab6.domain.implementation.Booking;

@Service
public class BookingService extends GeneralService<Booking> {

    @Autowired
    BookingRepository bookingRepository;

    @Override
    public JpaRepository<Booking, Integer> getRepository() {
        return bookingRepository;
    }

}
