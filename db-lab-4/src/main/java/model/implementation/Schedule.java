package model.implementation;

import model.IGeneralModel;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "schedule", schema = "oprysk_db")
public class Schedule implements IGeneralModel {
    private static final String tableName = Schedule.class.getSimpleName();
    private Integer id;
    private String arrivalTime;
    private String departureTime;

    public Schedule() {
    }

    public Schedule(Integer id, String arrivalTime, String departureTime) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
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
    @Column(name = "arrival_time")
    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Basic
    @Column(name = "departure_time")
    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return Objects.equals(id, schedule.id) &&
                Objects.equals(arrivalTime, schedule.arrivalTime) &&
                Objects.equals(departureTime, schedule.departureTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, arrivalTime, departureTime);
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", departureTime='" + departureTime + '\'' +
                '}';
    }
}
