package com.lab6.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.lab6.repository.TicketRepository;
import com.lab6.domain.implementation.Ticket;

@Service
public class TicketService extends GeneralService<Ticket> {

    @Autowired
    TicketRepository ticketRepository;

    @Override
    public JpaRepository<Ticket, Integer> getRepository() {
        return ticketRepository;
    }

}
