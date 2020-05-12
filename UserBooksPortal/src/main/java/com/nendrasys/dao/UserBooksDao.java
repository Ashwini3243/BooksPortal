package com.nendrasys.dao;


import com.nendrasys.model.RegistrationModel;
import com.nendrasys.model.UserBooksInfo;

import java.security.Principal;
import java.util.List;

public interface UserBooksDao {
    List<UserBooksInfo> getBoooksDetails1();
    public RegistrationModel getRegistredDetailsbyid(Principal principal);
}
