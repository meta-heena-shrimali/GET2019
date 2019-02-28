package com.metacube.springMVC.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.springMVC.mapper.UserMapper;
import com.metacube.springMVC.model.User;


@Repository
public class UserDAO {

    private JdbcTemplate jdbcTemplate;

    private final String SQL_FIND_PROJECT = "select * from User where id = ?";
    private final String SQL_DELETE_PROJECT = "delete from User where id = ?";
    private final String SQL_UPDATE_PROJECT = "update User set first_name = ?, last_name = ?, contact_no  = ?, email  = ? where id = ?";
    private final String SQL_GET_ALL = "select * from User";
    private final String SQL_INSERT_PROJECT = "insert into User(first_name, last_name, contact_no, email) values(?,?,?,?)";
    String asd="select * from User where first_name = 'xyz'";

    @Autowired
    public UserDAO(DataSource dataSource) {
        super();
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public boolean add(User user) {
        return jdbcTemplate.update(SQL_INSERT_PROJECT, user.getFirstName(), 
                user.getLastName(),user.getContactNo(), user.getEmail()) > 0;
    }
    
    public User get(Integer id) {
        return jdbcTemplate.queryForObject(SQL_FIND_PROJECT, new Object[] { id }, new UserMapper());
    }

    public List<User> getAll() {
        return jdbcTemplate.query(SQL_GET_ALL, new UserMapper());
    }
    
    public boolean update(User user) {
        return jdbcTemplate.update(SQL_UPDATE_PROJECT, user.getFirstName(), 
                user.getLastName(), user.getContactNo(),user.getLastName(),user.getId()) > 0;
    }

    public boolean delete(Integer id) {
        return jdbcTemplate.update(SQL_DELETE_PROJECT, id) > 0;
    }

    public  List<User> search(String searchBy,String userInfo) {
		String SQL_SEARCH = "select * from User where "+searchBy+" = "+"\""+ userInfo +"\";";
		System.out.println(SQL_SEARCH);
//		return jdbcTemplate.query(SQL_SEARCH,new UserMapper());
//		return jdbcTemplate.query(asd, new UserMapper());
		return jdbcTemplate.query("select * from User where "+searchBy +"=\""+ userInfo +"\";"  ,new UserMapper());
	}

	
}


