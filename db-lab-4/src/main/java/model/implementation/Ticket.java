package model.implementation;

import model.IGeneralModel;

public class Ticket implements IGeneralModel {
    private Integer id;
    private Integer price;
    private Integer paymentBookingId;

    public Ticket(Integer id, Integer price, Integer paymentBookingId) {
        this.id = id;
        this.price = price;
        this.paymentBookingId = paymentBookingId;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPaymentBookingId() {
        return paymentBookingId;
    }

    public void setPaymentBookingId(Integer paymentBookingId) {
        this.paymentBookingId = paymentBookingId;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", price=" + price +
                ", paymentBookingId=" + paymentBookingId +
                '}';
    }
}
