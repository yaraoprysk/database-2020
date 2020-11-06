package model.implementation;

import model.IGeneralModel;

public class Client implements IGeneralModel {
    private Integer id;
    private Integer currentInfoAboutThePlaneId;
    private Integer bookingId;
    private Integer ticketId;
    private Integer infoClientId;

    public Client(Integer id, Integer currentInfoAboutThePlaneId, Integer bookingId, Integer ticketId, Integer infoClientId) {
        this.id = id;
        this.currentInfoAboutThePlaneId = currentInfoAboutThePlaneId;
        this.bookingId = bookingId;
        this.ticketId = ticketId;
        this.infoClientId = infoClientId;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCurrentInfoAboutThePlaneId() {
        return currentInfoAboutThePlaneId;
    }

    public void setCurrentInfoAboutThePlaneId(Integer currentInfoAboutThePlaneId) {
        this.currentInfoAboutThePlaneId = currentInfoAboutThePlaneId;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public Integer getInfoClientId() {
        return infoClientId;
    }

    public void setInfoClientId(Integer infoClientId) {
        this.infoClientId = infoClientId;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", currentInfoAboutThePlaneId=" + currentInfoAboutThePlaneId +
                ", bookingId=" + bookingId +
                ", ticketId=" + ticketId +
                ", infoClientId=" + infoClientId +
                '}';
    }
}