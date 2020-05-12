package com.nendrasys.dao;

import com.nendrasys.model.BooksInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ServerBooksDaoImpl implements ServerBooksDao {

    @Autowired
    JdbcTemplate jdbcTemplate;
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int saveBooksData(BooksInfo reg) {
        String query = "insert into BookServerDb(bookId,bookName,bookAuthor,bookDesc,price,language ) values('" + reg.getBookId() + "','" + reg.getBookName() + "','" + reg.getBookAuthor() + "','" + reg.getBookDesc() + "','" + reg.getPrice() + "','" + reg.getLanguage() + "')";
        return jdbcTemplate.update(query);
    }

    @Override
    public int getCount() {
        String q="select count(*) from BookServerDb";
        int count = getJdbcTemplate().queryForObject(q,Integer.class);
        return count;
    }

    @Override
    public List<BooksInfo> getBookDetails() {
        List<BooksInfo> booksInfoList = jdbcTemplate.query("select * from BookServerDb ", new RowMapper<BooksInfo>() {
            @Override
            public BooksInfo mapRow(ResultSet rs, int i) throws SQLException {
                BooksInfo b = new BooksInfo();
                b.setBookId(rs.getInt("bookId"));
                b.setBookName(rs.getString("bookName"));
                b.setBookAuthor(rs.getString("bookAuthor"));
                b.setBookDesc(rs.getString("bookDesc"));
                b.setPrice(rs.getDouble("price"));
                b.setLanguage(rs.getString("language"));
                return b;
            }
        });
        return booksInfoList;

    }

    @Override
    public BooksInfo getBooksDetailsById(int bookId) {
        String QUERY1="SELECT * FROM BookServerDb WHERE bookId = ?";
        BooksInfo booksInfo = (BooksInfo) jdbcTemplate.queryForObject(QUERY1, new BeanPropertyRowMapper(BooksInfo.class), bookId);
        return booksInfo;
    }


}
