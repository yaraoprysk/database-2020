package DAO.implementation;

import model.implementation.Ticket;

public class TicketDAO extends GeneralDAO<Ticket> {
    public final Class<Ticket> getClazz() {
        return Ticket.class;

    }
}
