package com.nendrasys.services;

import com.nendrasys.dao.ServerBooksDaoImpl;
import com.nendrasys.model.BooksInfo;
import com.nendrasys.model.BooksList;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;

public class BooksServerServiceImpl implements BooksServerService {
    @Autowired
    OxmServices oxmServices;
    @Autowired
    ServerBooksDaoImpl serverDao;

    public OxmServices getOxmServices() {
        return oxmServices;
    }

    public void setOxmServices(OxmServices oxmServices) {
        this.oxmServices = oxmServices;
    }

    public ServerBooksDaoImpl getServerDao() {
        return serverDao;
    }

    public void setServerDao(ServerBooksDaoImpl serverDao) {
        this.serverDao = serverDao;
    }

    @Override
    public List<BooksInfo> getBookDetails() {

        return serverDao.getBookDetails();
    }

    @Override
    public String saveBooksData(BooksInfo reg) {
        int count = 0;
        count= serverDao.saveBooksData(reg);
        if(count==1){
            return "Data is Inserted successfully";
        }
        else{
            return "Data is not Inserted";
        }
    }

    @Override
    public BooksInfo getBooksDetailsById(int bookId) {
        return serverDao.getBooksDetailsById(bookId);
    }

    //marshalling by id
    @Override
    public String convertObjectToxml1(int bookId) throws IOException {
        BooksInfo s1=serverDao.getBooksDetailsById(bookId);
        return oxmServices.convertObjectToxml(s1);
    }

    //unmarshaling by id
    @Override
    public BooksInfo converXmlToObject1(String xml) throws IOException {
        return oxmServices.convertXmlToObject(xml);
    }
    // marshalling Studentlist
    @Override
    public String booksListInXml() throws IOException {
        BooksList booksList=new BooksList() ;
        booksList.setBooksInfoList(serverDao.getBookDetails());
        return oxmServices.BooksListInXml(booksList);
    }

    @Override
    public BooksList booksListInObj(String xml) throws IOException {
        return  (BooksList) oxmServices.booksListInObj(xml);
    }


}
