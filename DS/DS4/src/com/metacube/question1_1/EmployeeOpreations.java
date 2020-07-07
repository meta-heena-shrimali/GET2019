package com.metacube.question1_1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeOpreations {
	List<Employee> listOfEmployee = new ArrayList<Employee>();
	/*
	 * add employee object to list using the collection
	 * @param emp
	 */
	public void addEmployee(Employee emp) {
		listOfEmployee.add(emp);
	}
	/*
	 * sort the employee object using the comparable by EmpId
	 */
	public void sortedList() {
		Collections.sort(listOfEmployee);
	}
	/*
	 * print the list of employee object
	 */
	public void printList() {
		for(Employee emp: listOfEmployee) {
			System.out.println(emp.toString());
		}
	}
}
