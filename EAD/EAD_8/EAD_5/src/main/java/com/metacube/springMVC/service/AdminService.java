package com.metacube.springMVC.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.springMVC.model.Admin;
import com.metacube.springMVC.repository.AdminRepository;


@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    
    public boolean isValidAdmin(String username, String password) {
        try {
            List<Admin> admins = adminRepository.findAll();
            for (Admin ad : admins) {
                if (username.equals(ad.getUsername())
                        && password.equals(ad.getPassword()))
                    return true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
}