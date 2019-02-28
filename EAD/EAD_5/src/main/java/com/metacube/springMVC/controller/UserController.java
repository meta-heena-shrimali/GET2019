package com.metacube.springMVC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.springMVC.model.User;
import com.metacube.springMVC.service.UserService;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    
    
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model m) {
//        m.addAttribute("x",new User());
        return "user/add";
    }
    
    
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(User user) {
        userService.add(user);
        return "redirect:/user/all";
    }
    
    @RequestMapping(value = "/edit/{userId}", method = RequestMethod.GET)
    public ModelAndView get( @PathVariable("userId") Integer userId) {
        User user = userService.get(userId);
        return new ModelAndView("user/edit", "user",user);
    }
    
    
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(User user) {
        userService.update(user);
        return "redirect:/user/all";
    }
   
    
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ModelAndView getAll() {
        List<User> user = userService.getAll(); 
        return new ModelAndView("user/all", "user", user);
    }
    
    @RequestMapping(value = "/delete/{userId}", method = RequestMethod.GET)
    public String delete(@PathVariable("userId") Integer userId) {
        userService.delete(userId);
        return "redirect:/user/all";
    }
   
	@RequestMapping(value="/search",method = RequestMethod.GET)
	public String search() {
		System.out.println(" user controller get request ");
		return "user/search";
	}
	
	
	
	@RequestMapping(value="/search",method = RequestMethod.POST)
	public ModelAndView search(@RequestParam("searchBy")String searchBy,@RequestParam("userInfo")String userInfo) {
		System.out.println(" user controller post request ");
		List<User> users = userService.search(searchBy,userInfo);
		
		return new ModelAndView("user/all", "user", users);
	}

    
}
