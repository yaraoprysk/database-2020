package model.implementation;

import model.IGeneralModel;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "plane_info", schema = "oprysk_db")
public class PlaneInfo implements IGeneralModel {
    private static final String tableName = PlaneInfo.class.getSimpleName();
    private Integer id;
    private Integer numberSeats;
    private String status;

    public PlaneInfo() {
    }

    public PlaneInfo(Integer id, Integer numberSeats, String status) {
        this.id = id;
        this.numberSeats = numberSeats;
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
    @Column(name = "number_seats")
    public Integer getNumberSeats() {
        return numberSeats;
    }

    public void setNumberSeats(Integer numberSeats) {
        this.numberSeats = numberSeats;
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
        PlaneInfo planeInfo = (PlaneInfo) o;
        return Objects.equals(id, planeInfo.id) &&
                Objects.equals(numberSeats, planeInfo.numberSeats) &&
                Objects.equals(status, planeInfo.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numberSeats, status);
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
