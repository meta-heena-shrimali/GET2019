package com.metacube.question1_2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeOpreations {
    List<Employee> listOfEmployee = new ArrayList<Employee>();
    /*
     * add the employee in the list
     * @param emp of type Employee
     */
    public void addEmployee(Employee emp) {
        listOfEmployee.add(emp);  
    }
    /*
     * sorting of the employee on the basis of empName
     */
    public void sortEmployeeByName() {
    	Collections.sort(listOfEmployee,Employee.compareByName);
    }
    /*
     * print the list of Employee
     */
    public void printList() {
        for(int i =0;i<listOfEmployee.size();i++) {
            System.out.println(listOfEmployee.get(i).toString());
        }
        
    }

}
