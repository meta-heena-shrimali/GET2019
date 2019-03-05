package com.metacube.springBoot.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.springBoot.service.AdminService;

@Controller
public class WebSiteController {

	  @Autowired
	    private AdminService adminService;
	    
	    
		  @RequestMapping(value = "/", method = RequestMethod.GET)
		    public String home() {     
		        return "login";
		    }
		  
		    @RequestMapping(value = "login", method = RequestMethod.POST)
		    public ModelAndView login(@RequestParam("username") String username, @RequestParam("password") String password) {       
		        if (adminService.isValidAdmin(username, password)) {
		            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		            HttpSession session= attr.getRequest().getSession(true);
		            session.setAttribute("loginCredentials",username);
		            return new ModelAndView("welcome");
		        } else {
		            return new ModelAndView("login");
		        }
		    }
		    
		    
		     @RequestMapping(value = "/welcome", method = RequestMethod.GET)
		        public String welcome() {    
		         ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
	             HttpSession session= attr.getRequest().getSession(true);
	             String loginCredentials =(String)session.getAttribute("loginCredentials");
	             if(loginCredentials != null)
		            return "welcome";
	             else
	                 return "redirect:/";
		        }
		     
		     
		     @RequestMapping(value = "/logout", method = RequestMethod.GET)
		        public String logout() {  
		           ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		             HttpSession session= attr.getRequest().getSession();
		             session.removeAttribute("loginCredentials");
		            return "login";
		        }
}
