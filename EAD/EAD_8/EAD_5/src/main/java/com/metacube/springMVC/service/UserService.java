package com.metacube.springMVC.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.springMVC.model.User;
import com.metacube.springMVC.repository.UserRepository;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

   
    public boolean add(User user) {
        try {
            User u = userRepository.save(user);
            if (u != null)
                return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    
    public User get(Integer id) {
        try {
            return userRepository.findOne(id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

   

    public boolean update(User user) {
        try {
            User u = userRepository.save(user);
            if (u != null)
                return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

   
    public List<User> getAll() {
        try {
            return userRepository.findAll();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

   
    public boolean delete(Integer id) {
        try {
            userRepository.delete(id);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    
    public List<User> search(String searchBy, String userInfo) {
        try {
            if (searchBy.equals("first_name"))
                return userRepository.findByFirstName(userInfo);
            else if (searchBy.equals("last_name"))
                return userRepository.findByLastName(userInfo);
            else if (searchBy.equals("contact_no"))
                return userRepository.findByContactNo(userInfo);
            else if (searchBy.equals("email"))
                return userRepository.findByEmail(userInfo);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}


