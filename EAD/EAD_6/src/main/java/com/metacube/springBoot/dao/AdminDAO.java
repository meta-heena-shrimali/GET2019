package com.metacube.springBoot.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.springBoot.mapper.AdminMapper;
import com.metacube.springBoot.model.Admin;

@Repository
public class AdminDAO {

    private JdbcTemplate jdbcTemplate;
   
    @Autowired
    public AdminDAO(DataSource dataSource) {
        super();
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
   
    public boolean isValidAdmin(String username, String password){
       List <Admin> admins = jdbcTemplate.query("select * from admin", new AdminMapper()); 
       for(Admin admin: admins){
           if( username.equals(admin.getUsername()) && password.equals(admin.getPassword()))
               return true;
       }
       return false;
    }
}
