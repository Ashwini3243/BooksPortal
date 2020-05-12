package com.nendrasys.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nendrasys.model.RegistrationModel;
import com.nendrasys.model.UserBooksInfo;
import com.nendrasys.model.UserBooksList;
import com.nendrasys.service.RestCallToServer;
import com.nendrasys.service.UserBooksServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.security.Principal;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

@Controller
@RequestMapping("/")
public class RestController {

    @Autowired
    RestCallToServer restCallToServer;
    @Autowired
    UserBooksServiceImpl booksService;

    @ResponseBody
    @RequestMapping(value = "/getBooksDataInXml",produces = {"application/xml"})
    public UserBooksList getRestBooks() throws JsonProcessingException {
        return  restCallToServer.getServerBooksData();
    }

    @ResponseBody
    @RequestMapping(value = "/getBooksDataInJson",produces = {"application/json"})
    public UserBooksList getRestBooksByJson(){
        return restCallToServer.getServeBooksDataInJson();
    }

    @RequestMapping(value = "/getBookByIdInXml/{bookId}",produces = "application/xml")
    public ResponseEntity<UserBooksInfo> getBookById (@PathVariable("bookId") int bookId)
    {
        if (bookId <= 100) {
            UserBooksInfo booksInfoServer = restCallToServer.getServerBooksDataInXmlById(bookId);
            return new ResponseEntity<UserBooksInfo>(booksInfoServer, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/getBookByIdInJson/{bookId}",produces = "application/json")
    public ResponseEntity<UserBooksInfo> getBookByIdInJson (@PathVariable("bookId") int bookId)
    {
        if (bookId <= 100) {
            UserBooksInfo booksInfoServer = restCallToServer.getServerBooksDataInJsonById(bookId);
            return new ResponseEntity<UserBooksInfo>(booksInfoServer, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "getObj/{bookId}")
    public String getBookObjById(@PathVariable("bookId") int bookId, Model model,Principal principal,Locale locale,Double dbl) throws IOException {
        Authentication auth =  SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)){
            UserBooksInfo bookinfo=restCallToServer.getServerBooksDataInXmlById(bookId);
            RegistrationModel str=booksService.getUserdetailsbyid(principal);
            String c=str.getCountry();
            if(c.equals("US")){
                dbl=bookinfo.getPrice();
                dbl=dbl*70;
                System.out.println(dbl+"dbl1");
            }else if(c.equals("IN")){
                dbl=bookinfo.getPrice();

            }
            Locale indiaLocale = new Locale("ST", c);
/*          System.out.println(indiaLocale);
            System.out.println("Locale: " + indiaLocale.getDisplayName());
            Currency currency = Currency.getInstance(indiaLocale);
            NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(indiaLocale);
            System.out.println("formater "+currencyFormatter.format(dbl));
            System.out.println("Currency Code: " + currency.getCurrencyCode() +dbl);
            System.out.println("  both code formater"+currency.getCurrencyCode()+"  "+currencyFormatter.format(dbl));
            String str1=currencyFormatter.format(dbl);
            System.out.println(str1);
            System.out.println("Symbol: " + currency.getSymbol());*/
            Currency currency = Currency.getInstance(indiaLocale);
            NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(indiaLocale);
            String str1=currencyFormatter.format(dbl);
            model.addAttribute("price",str1);
            model.addAttribute("data",bookinfo);
            return "bookInfoById";}
        else {

            UserBooksInfo bookinfo=restCallToServer.getServerBooksDataInXmlById(bookId);
            model.addAttribute("data",bookinfo);
            return "bookInfoByIdwouprice";
        }
    }


    @RequestMapping("/getUserDetails")
    @ResponseBody
    public RegistrationModel getUserDetails(Principal authentication, Locale locale, double dbl){
        RegistrationModel str=booksService.getUserdetailsbyid(authentication);
        System.out.println(str.getCountry());
        System.out.println(str);
        return str;
    }
    @RequestMapping(value = "/getObjByList")
    public String getBooksObj(Model model, Principal principal,Double dbl) throws IOException {

        Authentication auth =  SecurityContextHolder.getContext().getAuthentication();
              if (!(auth instanceof AnonymousAuthenticationToken)){
            UserBooksList bookinfo=restCallToServer.getServeBooksDataInJson();
            RegistrationModel str=booksService.getUserdetailsbyid(principal);
            String c=str.getCountry();
            Locale indiaLocale = new Locale("ST", c);
            System.out.println(indiaLocale);
            //System.out.println("Locale: " + indiaLocale.getDisplayName());
        /*  Currency currency = Currency.getInstance(indiaLocale);
            System.out.println(" currency"+currency);
            NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(indiaLocale);
            System.out.println(currencyFormatter+"curency format");*/
            /* System.out.println("formater "+currencyFormatter.format(dbl));
            System.out.println("Currency Code: " + currency.getCurrencyCode() +dbl);
            System.out.println("  both code formater"+currency.getCurrencyCode()+"  "+currencyFormatter.format(dbl));
            */
            Currency currency = Currency.getInstance(indiaLocale);
            NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(indiaLocale);
             String str1=currency.getCurrencyCode()+" "+dbl;
           /* System.out.println("str1   "  +str1);
            System.out.println("Symbol: " + currency.getSymbol());*/
            model.addAttribute("price",str1);
            model.addAttribute("data",bookinfo);
            return "booksListWLogin";
        }
             UserBooksList bookinfo=restCallToServer.getServeBooksDataInJson();
            model.addAttribute("data",bookinfo);
             return "booksListWOutLogin";
    }
}
