package com.metacube.springMVC.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metacube.springMVC.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
