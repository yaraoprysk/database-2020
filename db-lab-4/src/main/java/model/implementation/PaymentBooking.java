package model.implementation;

import model.IGeneralModel;

public class PaymentBooking implements IGeneralModel {
    private Integer id;
    private String status;

    public PaymentBooking(Integer id, String status) {
        this.id = id;
        this.status = status;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PaymentBooking{" +
                "id=" + id +
                ", status='" + status + '\'' +
                '}';
    }
}
