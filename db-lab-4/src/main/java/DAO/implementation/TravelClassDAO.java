package DAO.implementation;

import model.implementation.TravelClass;

public class TravelClassDAO extends GeneralDAO<TravelClass> {
    public final Class<TravelClass> getClazz() {
        return TravelClass.class;

    }
}
