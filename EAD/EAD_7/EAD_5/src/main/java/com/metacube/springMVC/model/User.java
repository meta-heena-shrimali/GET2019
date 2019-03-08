package com.metacube.springMVC.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "first_name")
    private String first_name;
    
    @Column(name = "last_name")
    private String last_name;
    
    @Column(name = "contact_no")
    private String contact_no;
    
    @Column(name = "email")
    private String email;

    public User() {
    }
    
    public User(int id, String firstName, String lastName, String contactNo, String email) {
        this.id = id;
        this.first_name = firstName;
        this.last_name = lastName;
        this.contact_no = contactNo;
        this.email = email;
    }

     public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return first_name;
    }
    public void setFirstName(String firstName) {
        this.first_name = firstName;
    }
    public String getLastName() {
        return last_name;
    }
    public void setLastName(String lastName) {
        this.last_name = lastName;
    }
    public String getContactNo() {
        return contact_no;
    }
    public void setContactNo(String contactNo) {
        this.contact_no = contactNo;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public String toString() {
        return "User [id=" + id + ", firstName=" + first_name + ", lastName=" + last_name + ", contactNo=" + contact_no
                + ", email=" + email + "]";
    }
    
}