package com.nendrasys.dao;

import com.nendrasys.model.BooksInfo;

import java.util.List;

public interface ServerBooksDao {
    int saveBooksData(BooksInfo reg);
    int getCount();
    List<BooksInfo> getBookDetails();
    BooksInfo getBooksDetailsById(int bookId);

}
