package com.metacube.question1_2;
import java.util.Comparator;

public class Employee {
    int id;
    String name;
    String address;
    
    public Employee(Integer empId, String empName, String empAddress) throws Exception {
        super();
        if(empId == null || empName == null || empAddress == null)
			throw new Exception("Null value passed as input can't create employee");
        if(empId < 1)
			throw new Exception("invalid employee id cant be less than 1");
		if(empName.length() == 0 )
			throw new Exception("invalid employee name empty string passed as input");
		if( empAddress.length() == 0)
			throw new Exception("invalid employee address empty string passed as input");
        this.id = empId;
        this.name = empName;
        this.address = empAddress;
    }
    
    public String getEmployeeName() {
        return name;
    }
    /*
     * sort the Employee list using the comparator by name 
     */
    public static Comparator<Employee> compareByName = new Comparator<Employee>() {

        public int compare(Employee employee1, Employee employee2) {

           String empName1 = employee1.getEmployeeName();
           String empName2 = employee2.getEmployeeName();

           return empName1.compareTo(empName2);
       }
      };

    @Override
    public String toString() {
    	return "Employee [Id=" + id + ", Name=" + name + ", Address=" + address + "]";
    }
       
}
