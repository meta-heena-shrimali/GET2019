package com.metacube.question1_3;
import java.util.HashMap;
import java.util.Map;

public class EmployeeOpreations {
    Map<Integer,Employee> listOfEmployee = new HashMap<Integer,Employee>();
   /*
    * add employee without duplicate id the duplicate Id is Encountered it is avoided
    * @param emp
    */
    public void addEmployee(Employee emp) {
        if(listOfEmployee.get(emp.getEmpId()) == null)
            listOfEmployee.put(emp.getEmpId(),emp);
    }
   /*
    * print the list of the employee
    */
    public void printList() {
       for(Employee employee:listOfEmployee.values())
            System.out.println(employee.toString());
        }
    }


