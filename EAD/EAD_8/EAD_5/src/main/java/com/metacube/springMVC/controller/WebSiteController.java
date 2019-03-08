package com.metacube.springMVC.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.springMVC.service.AdminService;

@Controller
public class WebSiteController {

    @Autowired
    private AdminService adminService;
    private String incorrectCredential ="please Enter correct Username and Password";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
    	System.out.println(" login page ");
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam("username") String username,
            @RequestParam("password") String password) {
        if (adminService.isValidAdmin(username, password)) {
            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            HttpSession session = attr.getRequest().getSession(true);
            session.setAttribute("currentUser", username);
            return new ModelAndView("welcome");
        } else {
            return new ModelAndView("login","status",incorrectCredential);
        }
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome() {
        if (isLogedIn())
            return "welcome";
        else
            return "redirect:/";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attr.getRequest().getSession();
        session.removeAttribute("currentUser");
        return "login";
    }
    
    /**
     * 
     * @return  true if user is logged in
     */
    public boolean isLogedIn(){
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attr.getRequest().getSession(true);
        String currentUser = (String) session.getAttribute("currentUser");
        if (currentUser != null) {
            return true;
        }
        return false;
    }

}
