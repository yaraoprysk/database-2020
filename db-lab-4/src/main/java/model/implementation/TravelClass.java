package model.implementation;

import model.IGeneralModel;

public class TravelClass implements IGeneralModel {
    private Integer id;
    private String name;

    public TravelClass(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TravelClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}