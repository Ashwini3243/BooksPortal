package com.nendrasys.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nendrasys.model.UserBooksInfo;
import com.nendrasys.model.UserBooksList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

public class RestCallToServer {
    @Autowired
    private RestTemplate restTemplate;

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public UserBooksList getServerBooksData() throws JsonProcessingException {
        UserBooksInfo userBooksInfo = new UserBooksInfo();
        String url ="http://localhost:8083/ServerBooksPortal_war_exploded/getBooksListInXml";
        ResponseEntity<UserBooksInfo[]> obj = restTemplate.getForEntity(url, UserBooksInfo[].class);
        System.out.println(obj.getStatusCode().value());
        UserBooksList booksListServer = new UserBooksList();
        booksListServer.setUserBooksInfos(Arrays.asList(obj.getBody()));
        return booksListServer;

    }

    public UserBooksList getServeBooksDataInJson(){
        UserBooksInfo userBooksInfo = new UserBooksInfo();
        String url ="http://localhost:8083/ServerBooksPortal_war_exploded/getBooksListInXml";
        ResponseEntity<UserBooksInfo[]> obj = restTemplate.getForEntity(url, UserBooksInfo[].class);
        System.out.println(obj.getStatusCode().value());
        UserBooksList booksListServer = new UserBooksList();
        booksListServer.setUserBooksInfos(Arrays.asList(obj.getBody()));
        return booksListServer;
    }


    public UserBooksInfo getServerBooksDataInXmlById(int bookId){
        final String uri = "http://localhost:8083/ServerBooksPortal_war_exploded/getXml/{bookId}";
        RestTemplate restTemplate = new RestTemplate();
        UserBooksInfo result = restTemplate.getForObject(uri, UserBooksInfo.class,bookId);
        return result;
    }
    public UserBooksInfo getServerBooksDataInJsonById(int bookId){
        final String uri = "http://localhost:8083/ServerBooksPortal_war_exploded/getXml/{bookId}";
        RestTemplate restTemplate = new RestTemplate();
        UserBooksInfo result = restTemplate.getForObject(uri, UserBooksInfo.class,bookId);
        return result;
    }

}
