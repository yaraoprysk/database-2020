package controller.implementation;

import model.implementation.Ticket;
import service.IGeneralService;
import service.implementation.GeneralService;
import service.implementation.TicketService;

public class TicketController extends GeneralController<Ticket> {

    private final GeneralService<Ticket> ticketService = new TicketService();

    @Override
    public final IGeneralService<Ticket> getService() {
        return ticketService;
    }
}

