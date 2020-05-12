package com.nendrasys.controller;

import com.nendrasys.dao.UserRegistrationDaoImpl;
import com.nendrasys.model.RegistrationModel;
import com.nendrasys.service.UserBooksServiceImpl;
import com.nendrasys.validations.RegistrationValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("/RegistrationController")
@RequestMapping("/")
public class RegistrationController {
    @Autowired
    UserRegistrationDaoImpl registrationDao;
    @Autowired
    UserBooksServiceImpl booksService;
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String displayREgisterForm(Model model) {
        RegistrationModel reg = new RegistrationModel();
        model.addAttribute("reg", reg);
        return "Register";
    }

    @RequestMapping(value = "/saveRegData", method = RequestMethod.POST)
    public String registerAction(Model model, @ModelAttribute("reg") RegistrationModel reg,BindingResult result){
        System.out.println(reg);
        new RegistrationValidation().validate(reg, result);
        if (result.hasErrors()) {
            return "Register";
        }
        else {
            String str = booksService.saveRegisteredData(reg);
            model.addAttribute("str", str);
            return "registerSuccessMsg";
        }

    }

    @ModelAttribute("rolesList")
    public List<String> rolesList() {
        List<String> list = new ArrayList<>();
        list.add("ROLE_U");
        return list;
    }

    @ModelAttribute("countriesList")
    public Map<String, String> getCountryList() {
        Map<String, String> countryList = new HashMap<String, String>();
        countryList.put("US", "United States");
        countryList.put("IN", "India");

        return countryList;
    }
}
