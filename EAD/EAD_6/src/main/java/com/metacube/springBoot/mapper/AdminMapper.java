package com.metacube.springBoot.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.springBoot.model.Admin;

public class AdminMapper implements RowMapper<Admin> {

    public Admin mapRow(ResultSet resultSet, int i) throws SQLException {
        Admin project = new Admin();
        project.setUsername(resultSet.getString("username"));
        project.setPassword(resultSet.getString("password"));
        return project;
    }

}
