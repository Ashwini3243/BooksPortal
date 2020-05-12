package com.nendrasys.service;

import com.nendrasys.dao.UserBooksDaoImpl;
import com.nendrasys.dao.UserRegistrationDaoImpl;
import com.nendrasys.model.RegistrationModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.Principal;

public class UserBooksServiceImpl implements UserBooksService {


    @Autowired
    UserBooksDaoImpl booksDao;
    @Autowired
    RestCallToServer restCallToServer;
    @Autowired
    UserRegistrationDaoImpl registrationDao;
    @Override
    public RegistrationModel getUserdetailsbyid(Principal id)
    {
        return booksDao.getRegistredDetailsbyid(id);
    }

    @Override
    public String saveRegisteredData(RegistrationModel reg) {
        int count = 0;
        count=registrationDao.saveRegisteredData(reg);
        if(count==1){
            return "Data is Inserted successfully";
        }
        else{
            return "Data is not Inserted";
        }
    }

}
