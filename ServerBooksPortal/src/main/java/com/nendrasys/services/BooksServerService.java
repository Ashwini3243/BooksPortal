package com.nendrasys.services;

import com.nendrasys.model.BooksInfo;
import com.nendrasys.model.BooksList;

import java.io.IOException;
import java.util.List;

public interface BooksServerService {
    List<BooksInfo> getBookDetails();
    String saveBooksData(BooksInfo reg);
    BooksInfo getBooksDetailsById(int bookId);
    public String convertObjectToxml1(int bookId) throws IOException;
    public BooksInfo converXmlToObject1(String bookId) throws  IOException;
    public String booksListInXml() throws IOException;
    public BooksList booksListInObj(String xml) throws IOException;

}
