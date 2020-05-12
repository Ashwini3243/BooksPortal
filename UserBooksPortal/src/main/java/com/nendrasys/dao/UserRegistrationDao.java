package com.nendrasys.dao;

import com.nendrasys.model.RegistrationModel;

public interface UserRegistrationDao {
    int saveRegisteredData(RegistrationModel reg);
}
