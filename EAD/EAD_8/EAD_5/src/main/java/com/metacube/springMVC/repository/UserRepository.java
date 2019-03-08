package com.metacube.springMVC.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.metacube.springMVC.model.User;
@Repository
public interface UserRepository  extends JpaRepository<User, Integer> {

	@Query("select u from User u where u.first_name = :first_name")
    public List<User> findByFirstName(@Param("first_name") String first_name);
	@Query("select u from User u where u.last_name = :last_name")
    public List<User> findByLastName(@Param("last_name") String last_name);
    @Query("select u from User u where u.contact_no = :contact_no")
    public List<User> findByContactNo(@Param("contact_no") String contact_no);
    @Query("select u from User u where u.email = :email")
    public List<User> findByEmail(@Param("email") String email);
}
