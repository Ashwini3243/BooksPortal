package com.nendrasys.dao;

import com.nendrasys.model.UserBooksInfo;
import com.nendrasys.model.RegistrationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.security.Principal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserBooksDaoImpl implements UserBooksDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<UserBooksInfo> getBoooksDetails1() {
        List<UserBooksInfo> userBooksInfoList = jdbcTemplate.query("select * from booksdb ", new RowMapper<UserBooksInfo>() {
            @Override
            public UserBooksInfo mapRow(ResultSet rs, int i) throws SQLException {
                UserBooksInfo s = new UserBooksInfo();
                s.setBookId(rs.getInt("bookId"));
                s.setBookName(rs.getString("bookName"));
                s.setBookAuthor(rs.getString("bookAuthor"));
                s.setBookDesc(rs.getString("bookDesc"));
                s.setPrice(rs.getDouble("price"));
                s.setLanguage(rs.getString("language"));
                System.out.println(s);
                return s;

            }
        });
        return userBooksInfoList;
    }

    @Override
    public RegistrationModel getRegistredDetailsbyid(Principal principal) {
        String QUERY1="select * from registrationtable where username='"+principal.getName()+"'";
        RegistrationModel registrationModel = (RegistrationModel) jdbcTemplate.queryForObject(QUERY1, new BeanPropertyRowMapper(RegistrationModel.class));
        return registrationModel;
    }

}