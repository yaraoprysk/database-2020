package DAO.implementation;

import model.implementation.RegistrationInfo;

public class RegistrationInfoDAO extends GeneralDAO<RegistrationInfo> {
    public final Class<RegistrationInfo> getClazz() {
        return RegistrationInfo.class;

    }
}