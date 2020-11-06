package model.implementation;

import model.IGeneralModel;

public class Airline implements IGeneralModel {
    private Integer id;
    private String name;
    private String country;


    public Airline(Integer id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Airline{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}

