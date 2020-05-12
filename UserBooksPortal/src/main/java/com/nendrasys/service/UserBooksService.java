package com.nendrasys.service;

import com.nendrasys.model.RegistrationModel;

import java.security.Principal;

public interface UserBooksService {

    RegistrationModel getUserdetailsbyid(Principal id);
    public String saveRegisteredData(RegistrationModel reg);
}
