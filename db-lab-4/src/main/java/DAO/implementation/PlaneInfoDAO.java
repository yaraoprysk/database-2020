package DAO.implementation;

import model.implementation.Airport;
import model.implementation.PlaneInfo;

public class PlaneInfoDAO extends GeneralDAO<PlaneInfo> {
    public final Class<PlaneInfo> getClazz() {
        return PlaneInfo.class;

    }
}