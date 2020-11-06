package model.implementation;

import model.IGeneralModel;

public class RegistrationInfo implements IGeneralModel {
    private Integer id;
    private Integer manufactureYear;
    private Integer generalPlaqueHours;
    private String model;
    private String boardNumber;

    public RegistrationInfo(Integer id, Integer manufactureYear, Integer generalPlaqueHours, String model, String boardNumber) {
        this.id = id;
        this.manufactureYear = manufactureYear;
        this.generalPlaqueHours = generalPlaqueHours;
        this.model = model;
        this.boardNumber = boardNumber;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(Integer manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public Integer getGeneralPlaqueHours() {
        return generalPlaqueHours;
    }

    public void setGeneralPlaqueHours(Integer generalPlaqueHours) {
        this.generalPlaqueHours = generalPlaqueHours;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBoardNumber() {
        return boardNumber;
    }

    public void setBoardNumber(String boardNumber) {
        this.boardNumber = boardNumber;
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