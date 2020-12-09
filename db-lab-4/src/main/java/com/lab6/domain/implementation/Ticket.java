package com.lab6.domain.implementation;

import com.lab6.domain.IGeneralModel;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table( name = "ticket", schema = "oprysk_db")
public class Ticket implements IGeneralModel {
    private Integer id;
    private Integer price;
    private PaymentBooking paymentBookingByPaymentBookingId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name= "price")
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id.equals(ticket.id) &&
                price.equals(ticket.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price);
    }

    @ManyToOne
    @JoinColumn(name = "payment_booking_id", referencedColumnName = "id", nullable = false)
    public PaymentBooking getPaymentBookingByPaymentBookingId() {
        return paymentBookingByPaymentBookingId;
    }

    public void setPaymentBookingByPaymentBookingId(PaymentBooking paymentBookingByPaymentBookingId) {
        this.paymentBookingByPaymentBookingId = paymentBookingByPaymentBookingId;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", price=" + price +
                ", paymentBookingByPaymentBookingId=" + paymentBookingByPaymentBookingId +
                '}';
    }
}
