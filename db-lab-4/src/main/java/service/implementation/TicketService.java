package service.implementation;

import DAO.IGeneralDAO;
import DAO.implementation.TicketDAO;
import model.implementation.Ticket;

public class TicketService extends GeneralService<Ticket> {
    private final IGeneralDAO<Ticket, Integer> ticketDAOImplementation = new TicketDAO();

    @Override
    public final IGeneralDAO<Ticket, Integer> getDAO() {
        return ticketDAOImplementation;
    }
}
