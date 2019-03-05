package com.metacube.springBoot.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.springBoot.model.User;


public class UserMapper implements RowMapper<User> {

    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User project = new User();
        project.setId(resultSet.getLong("id"));
        project.setFirstName(resultSet.getString("first_name"));
        project.setLastName(resultSet.getString("last_name"));
        project.setContactNo(resultSet.getString("contact_no"));
        project.setEmail(resultSet.getString("email"));
        return project;
    }

}
