package model.implementation;

import model.IGeneralModel;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "registration_info", schema = "oprysk_db")
public class RegistrationInfo implements IGeneralModel {
    private static final String tableName = RegistrationInfo.class.getSimpleName();
    private Integer id;
    private Integer manufactureYear;
    private Integer generalPlaqueHours;
    private String model;
    private String boardNumber;

    public RegistrationInfo() {
    }

    public RegistrationInfo(Integer id, Integer manufactureYear, Integer generalPlaqueHours, String model, String boardNumber) {
        this.id = id;
        this.manufactureYear = manufactureYear;
        this.generalPlaqueHours = generalPlaqueHours;
        this.model = model;
        this.boardNumber = boardNumber;
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
    @Column(name = "manufacture_year")
    public Integer getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(Integer manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    @Basic
    @Column(name = "general_plaque_hours")
    public Integer getGeneralPlaqueHours() {
        return generalPlaqueHours;
    }

    public void setGeneralPlaqueHours(Integer generalPlaqueHours) {
        this.generalPlaqueHours = generalPlaqueHours;
    }

    @Basic
    @Column(name = "model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Basic
    @Column(name = "board_number")
    public String getBoardNumber() {
        return boardNumber;
    }

    public void setBoardNumber(String boardNumber) {
        this.boardNumber = boardNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistrationInfo registrationInfo = (RegistrationInfo) o;
        return Objects.equals(id, registrationInfo.id) &&
                Objects.equals(manufactureYear, registrationInfo.manufactureYear) &&
                Objects.equals(generalPlaqueHours, registrationInfo.generalPlaqueHours) &&
                Objects.equals(model, registrationInfo.model) &&
                Objects.equals(boardNumber, registrationInfo.boardNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, manufactureYear, generalPlaqueHours, model, boardNumber);
    }

    @Override
    public String toString() {
        return "RegistrationInfo{" +
                "id=" + id +
                ", manufactureYear=" + manufactureYear +
                ", generalPlaqueHours=" + generalPlaqueHours +
                ", model='" + model + '\'' +
                ", boardNumber='" + boardNumber + '\'' +
                '}';
    }
}