package com.lab6.controller.implementation;

import com.lab6.domain.implementation.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lab6.service.IGeneralService;
import com.lab6.service.implementation.TicketService;

@RestController
@RequestMapping("ticket")
public class TicketController extends GeneralController<Ticket> {

    @Autowired
    TicketService ticketService;

    @Override
    public final IGeneralService<Ticket> getService() {
        return ticketService;
    }
}

