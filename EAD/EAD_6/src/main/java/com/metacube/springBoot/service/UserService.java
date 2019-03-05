package com.metacube.springBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.springBoot.dao.UserDAO;
import com.metacube.springBoot.model.User;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public boolean add(User user) {
        return userDAO.add(user);
    }

    public User get(Integer id) {
        return userDAO.get(id);
    }

    public boolean update(User user) {
        return userDAO.update(user);
    }

    public List<User> getAll() {
        return userDAO.getAll();
    }

	public List<User> search(String searchBy,String userInfo) {
		return userDAO.search(searchBy,userInfo);
		
	}
    public boolean delete(Integer id) {
        return userDAO.delete(id);
    }

    
}


