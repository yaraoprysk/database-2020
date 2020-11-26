package model.implementation;

import model.IGeneralModel;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "payment_booking", schema = "oprysk_db")
public class PaymentBooking implements IGeneralModel {
    private static final String tableName = PaymentBooking.class.getSimpleName();
    private Integer id;
    private String status;

    public PaymentBooking() {
    }

    public PaymentBooking(Integer id, String status) {
        this.id = id;
        this.status = status;
    }

    public static String getTableName() {
        return tableName;
    }

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentBooking paymentBooking = (PaymentBooking) o;
        return Objects.equals(id, paymentBooking.id) &&
                Objects.equals(status, paymentBooking.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status);
    }

    @Override
    public String toString() {
        return "PaymentBooking{" +
                "id=" + id +
                ", status='" + status + '\'' +
                '}';
    }
}
