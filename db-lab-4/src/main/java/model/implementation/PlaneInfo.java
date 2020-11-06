package model.implementation;

import model.IGeneralModel;

public class PlaneInfo implements IGeneralModel {
    private Integer id;
    private Integer numberSeats;
    private String status;

    public PlaneInfo(Integer id, Integer numberSeats, String status) {
        this.id = id;
        this.numberSeats = numberSeats;
        this.status = status;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumberSeats() {
        return numberSeats;
    }

    public void setNumberSeats(Integer numberSeats) {
        this.numberSeats = numberSeats;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PlaneInfo{" +
                "id=" + id +
                ", numberSeats=" + numberSeats +
                ", status='" + status + '\'' +
                '}';
    }
}
