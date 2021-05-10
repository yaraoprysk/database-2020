package com.lab6.repository;

import com.lab6.domain.implementation.PaymentBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentBookingRepository extends JpaRepository<PaymentBooking, Integer> {

}