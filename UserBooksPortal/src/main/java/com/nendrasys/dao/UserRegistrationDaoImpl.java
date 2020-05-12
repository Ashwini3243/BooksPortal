package com.nendrasys.dao;

import com.nendrasys.model.RegistrationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserRegistrationDaoImpl implements UserRegistrationDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int saveRegisteredData(RegistrationModel reg) {
        String query = "insert into registrationtable(id,name,age,email,address,country,username,password,role,enabled ) values('" + reg.getId() + "','" + reg.getName() + "','" + reg.getAge() + "','" + reg.getEmail() + "','" + reg.getAddress() + "','" + reg.getCountry() + "','" + reg.getUsername() + "','" + reg.getPassword() + "','" + reg.getRole() + "','" + reg.getEnabled() + "')";
         return jdbcTemplate.update(query);  }
    }

