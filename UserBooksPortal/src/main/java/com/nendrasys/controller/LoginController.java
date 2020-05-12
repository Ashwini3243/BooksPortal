package com.nendrasys.controller;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @RequestMapping("welcome")
    public String returnTheWelcomePage(){
        return "welcome";
    }

    @RequestMapping("/accessDenied")
    public String accessDenied(){

        return "accessDenied";
    }
    @RequestMapping("/logoutSuccess")
    public String LogoutSucessUrl(){

    return "logout";
    }

   @RequestMapping(value = "/login", method = RequestMethod.GET)
   public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                             @RequestParam(value = "logout", required = false) String logout) {

       ModelAndView m = new ModelAndView();
       if (error != null) {
           m.addObject("error", "Username or password does not match...!");
       }

       if (logout != null) {
           m.addObject("msg", "You have successfully logged out...! ");
       }

       m.setViewName("login");
       return m;
   }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("near logout"+auth);
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout=true";
    }
}
