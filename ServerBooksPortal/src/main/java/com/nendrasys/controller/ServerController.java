package com.nendrasys.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nendrasys.Validations.AddBookValidation;
import com.nendrasys.dao.ServerBooksDaoImpl;
import com.nendrasys.model.BooksInfo;
import com.nendrasys.model.BooksList;
import com.nendrasys.services.BooksServerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller("ServerController")
@RequestMapping("/")
public class ServerController {
    @Autowired
    ServerBooksDaoImpl serverDao;
    @Autowired
    BooksServerServiceImpl bookServerService;
    @Autowired
    AddBookValidation addBookValidator;

    // Add Book Form
    @RequestMapping(value = "/addBookForm", method = RequestMethod.GET)
    public String addBookForm( Model model) {
        BooksInfo a=new BooksInfo();
        int count=serverDao.getCount();
        a.setBookId(count+1);
        model.addAttribute("user",a);
        return "AddBookForm";
    }
    // Add book form Action
    @RequestMapping(value = "/addBookFormAction", method = RequestMethod.POST)
    public String saveBookData(@ModelAttribute("user") BooksInfo user, Model model, BindingResult result) {
       new AddBookValidation().validate(user, result);
        if (result.hasErrors()) {
            return "AddBookForm";
        }
        else {
            String str = bookServerService.saveBooksData(user);
            model.addAttribute("str", str);
            return "AddBookFormsuccess";
        }
    }

    @ModelAttribute("languages")
    public List<String> languages(){
        List<String> list = new ArrayList<>();
        list.add("English");
        list.add("Hindi");
        list.add("french");
        return list;
    }
    //Books List in table
    @RequestMapping(value = "/getBooksList",method = RequestMethod.GET)
    public String getBooksListDetails(Model model){
        List<BooksInfo> booksInfoList= bookServerService.getBookDetails();
        model.addAttribute("BooksList",booksInfoList);
        return "AllBooksList";
    }
    //Books Details By iD
    @RequestMapping(value = "/getBooksById/{bookId}")
    public String getBooksListById(Model model,@PathVariable("bookId") String bookId){
        Integer id1=Integer.parseInt(bookId);
        BooksInfo booksInfo=bookServerService.getBooksDetailsById(id1);
        model.addAttribute("bookById",booksInfo);
        return "DisplayBooksById";
    }
    @ResponseBody
    @RequestMapping(value = "/BooksJson",produces = {"application/json"})
    public String displayAllBooks() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(bookServerService.getBookDetails());
    }
    @ResponseBody
    @RequestMapping(value = "/BooksJsonById/{bookId}",produces = {"application/json"})
    public String displayBookById(@PathVariable("bookId") int bookId) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(bookServerService.getBooksDetailsById(bookId));
    }

    @RequestMapping(value = "/getXml/{bookId}" , produces = {"application/xml"})
    @ResponseBody
    public String getBooksXmlById(@PathVariable("bookId") int bookId) throws IOException, JAXBException {
        return bookServerService.convertObjectToxml1(bookId);
    }

    @RequestMapping(value = "getObj/{bookId}")
    @ResponseBody
    public BooksInfo getBooksObjById(@PathVariable("bookId") int bookId) throws IOException {
        String xml=bookServerService.convertObjectToxml1(bookId);
        BooksInfo studentinfo=bookServerService.converXmlToObject1(xml);
        return studentinfo;
    }

    @RequestMapping(value = "/getBooksListInXml", produces = {"application/xml"})
    @ResponseBody
    public String getAllBooksInXml() throws IOException {
        return bookServerService.booksListInXml();
    }

    @RequestMapping(value = "/getBooksObj")
    @ResponseBody
    public BooksList getBooksListObj() throws IOException {
        String xml=bookServerService.booksListInXml();
        BooksList studentList=bookServerService.booksListInObj(xml);
        return studentList;
    }

}
