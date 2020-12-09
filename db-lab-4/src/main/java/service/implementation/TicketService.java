package service.implementation;

import DAO.IGeneralDAO;
import DAO.implementation.GeneralDAO;
import DAO.implementation.TicketDAO;
import model.implementation.Ticket;

public class TicketService extends GeneralService<Ticket> {
    private final GeneralDAO<Ticket> TICKET_DAO = new TicketDAO();

    @Override
    public IGeneralDAO<Ticket> getDAO() {
        return TICKET_DAO;
    }
}