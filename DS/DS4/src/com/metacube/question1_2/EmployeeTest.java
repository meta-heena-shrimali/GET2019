package com.metacube.question1_2;

import static org.junit.Assert.*;

import org.junit.Test;
public class EmployeeTest {
	
	@Test
	public void testNullValueInput() {
		 try {
			 new Employee(null, "alka", "UttarPradesh");
		 }
		 catch (Exception e) {
			 assertEquals("Null value passed as input can't create employee", e.getMessage());
		 }
	}
	@Test
	public void testInvalidIdInput() {
		 try {
			 new Employee(-6, "alka", "UttarPradesh");
		 }
		 catch (Exception e) {
			 assertEquals("invalid employee id cant be less than 1", e.getMessage());
		 }
	}
	@Test
	public void testInvalidNameInput() {
		 try {
			 new Employee(3, "", "UttarPradesh");
		 }
		 catch (Exception e) {
			 assertEquals("invalid employee name empty string passed as input", e.getMessage());
		 }
	}
	@Test
	public void testInvalidAddressInput() {
		 try {
			 new Employee(3, "alka", "");
		 }
		 catch (Exception e) {
			 assertEquals("invalid employee address empty string passed as input", e.getMessage());
		 }
	}
	@Test
	public void sortingByEmpNameTest() throws Exception {
		 EmployeeOpreations ep = new EmployeeOpreations();
			ep.addEmployee(new Employee(1, "alka", "UttarPradesh"));
			ep.addEmployee(new Employee(4, "mukul", "Rajasthan"));
			ep.addEmployee(new Employee(2, "anita", "Rajasthan"));
			ep.addEmployee(new Employee(5, "akash", "delhi"));
			ep.addEmployee(new Employee(3, "mukesh", "punjab"));
	        ep.sortEmployeeByName();
	        ep.printList();
	}
}
