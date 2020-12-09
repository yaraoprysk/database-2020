package com.lab6.domain.implementation;

import com.lab6.domain.IGeneralModel;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "client", schema = "oprysk_db")
public class Client implements IGeneralModel {
    private Integer id;
    private CurrentInfoAboutThePlane currentInfoAboutThePlaneByCurrentInfoAboutThePlaneId;
    private Booking bookingByBookingId;
    private Ticket ticketByTicketId;
    private InfoClient infoClientByInfoClientId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id.equals(client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    @ManyToOne
    @JoinColumn(name = "current_info_about_the_plane_id", referencedColumnName = "id", nullable = false)
    public CurrentInfoAboutThePlane getCurrentInfoAboutThePlaneByCurrentInfoAboutThePlaneId() {
        return currentInfoAboutThePlaneByCurrentInfoAboutThePlaneId;
    }

    public void setCurrentInfoAboutThePlaneByCurrentInfoAboutThePlaneId(CurrentInfoAboutThePlane currentInfoAboutThePlaneByCurrentInfoAboutThePlaneId) {
        this.currentInfoAboutThePlaneByCurrentInfoAboutThePlaneId = currentInfoAboutThePlaneByCurrentInfoAboutThePlaneId;
    }

    @ManyToOne
    @JoinColumn(name = "booking_id", referencedColumnName = "id", nullable = false)
    public Booking getBookingByBookingId() {
        return bookingByBookingId;
    }

    public void setBookingByBookingId(Booking bookingByBookingId) {
        this.bookingByBookingId = bookingByBookingId;
    }

    @ManyToOne
    @JoinColumn(name = "ticket_id", referencedColumnName = "id", nullable = false)
    public Ticket getTicketByTicketId() {
        return ticketByTicketId;
    }

    public void setTicketByTicketId(Ticket ticketByTicketId) {
        this.ticketByTicketId = ticketByTicketId;
    }

    @ManyToOne
    @JoinColumn(name = "client_info_id", referencedColumnName = "id", nullable = false)
    public InfoClient getInfoClientByInfoClientId() {
        return infoClientByInfoClientId;
    }

    public void setInfoClientByInfoClientId(InfoClient infoClientByInfoClientId) {
        this.infoClientByInfoClientId = infoClientByInfoClientId;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", currentInfoAboutThePlaneByCurrentInfoAboutThePlaneId=" + currentInfoAboutThePlaneByCurrentInfoAboutThePlaneId +
                ", bookingByBookingId=" + bookingByBookingId +
                ", ticketByTicketId=" + ticketByTicketId +
                ", infoClientByInfoClientId=" + infoClientByInfoClientId +
                '}';
    }
}