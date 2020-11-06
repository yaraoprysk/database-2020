package model.implementation;

import model.IGeneralModel;

public class Airport implements IGeneralModel {
    private Integer id;
    private String city;
    private String name;

    public Airport(Integer id, String city, String name) {
        this.id = id;
        this.city = city;
        this.name = name;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
