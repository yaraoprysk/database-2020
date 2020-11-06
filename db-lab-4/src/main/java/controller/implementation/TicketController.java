package controller.implementation;

import model.implementation.Ticket;
import service.implementation.GeneralService;
import service.implementation.TicketService;

public class TicketController extends GeneralController<Ticket> {

    private static final TicketService TICKET_SERVICE = new TicketService();

    @Override
    public final GeneralService<Ticket> getService() {
        return TICKET_SERVICE;
    }

}
