package com.metacube.springBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.springBoot.dao.AdminDAO;


@Service
public class AdminService {
    
    @Autowired
    private AdminDAO adminDao;
    public boolean isValidAdmin(String username, String password){
        return adminDao.isValidAdmin(username, password);
    }

}
