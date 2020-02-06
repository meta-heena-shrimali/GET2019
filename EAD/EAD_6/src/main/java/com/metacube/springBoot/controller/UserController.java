package com.metacube.springBoot.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.springBoot.model.User;
import com.metacube.springBoot.service.UserService;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    
    
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
    	ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session= attr.getRequest().getSession(true);
        String loginCredentials =(String)session.getAttribute("loginCredentials");
        if(loginCredentials != null)
            return "user/add";
        else
            return "redirect:/";
     }
    
    
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(User user) {
    	  ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
	      HttpSession session= attr.getRequest().getSession(true);
	      String loginCredentials =(String)session.getAttribute("loginCredentials");
	      if(loginCredentials != null){
	          userService.add(user);
	          return "redirect:/user/all";
	      }else
	          return "redirect:/";
    }
    
    @RequestMapping(value = "/edit/{userId}", method = RequestMethod.GET)
    public ModelAndView get( @PathVariable("userId") Integer userId) {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session= attr.getRequest().getSession(true);
        String loginCredentials =(String)session.getAttribute("loginCredentials");
        if(loginCredentials != null){
            User user = userService.get(userId);
            return new ModelAndView("user/edit", "user",user);
        }else
            return new ModelAndView("redirect:/");
    }
    
    
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(User user) {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session= attr.getRequest().getSession(true);
        String loginCredentials =(String)session.getAttribute("loginCredentials");
        if(loginCredentials != null){
            userService.update(user);
            return "redirect:/user/all";}
        else
            return "redirect:/";
    }
   
    
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ModelAndView getAll() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session= attr.getRequest().getSession(true);
        String loginCredentials =(String)session.getAttribute("loginCredentials");
        if(loginCredentials != null){
            List<User> user = userService.getAll(); 
            return new ModelAndView("user/all", "user", user);
        }else
            return new ModelAndView("redirect:/");
    }
    
    @RequestMapping(value = "/delete/{userId}", method = RequestMethod.GET)
    public String delete(@PathVariable("userId") Integer userId) {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session= attr.getRequest().getSession(true);
        String loginCredentials =(String)session.getAttribute("loginCredentials");
        if(loginCredentials != null){
            userService.delete(userId);
            return "redirect:/user/all";
        }else
            return "redirect:/";
    }
   
	@RequestMapping(value="/search",method = RequestMethod.GET)
	public String search() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session= attr.getRequest().getSession(true);
        String loginCredentials =(String)session.getAttribute("loginCredentials");
        if(loginCredentials != null){
            return "user/search";
        }else
            return "redirect:/";
	}
	
	
	
	@RequestMapping(value="/search",method = RequestMethod.POST)
	public ModelAndView search(@RequestParam("searchBy")String searchBy,@RequestParam("userInfo")String userInfo) {
		 ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
	        HttpSession session= attr.getRequest().getSession(true);
	        String loginCredentials =(String)session.getAttribute("loginCredentials");
	        if(loginCredentials != null){
	        	List<User> users = userService.search(searchBy,userInfo);	
	    		return new ModelAndView("user/all", "user", users);
	        }else
	            return new ModelAndView("redirect:/");
	}

    
}
