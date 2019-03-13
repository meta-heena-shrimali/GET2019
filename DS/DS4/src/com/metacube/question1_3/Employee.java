package com.metacube.question1_3;

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
    public int getEmpId() {
        return id;
    }
   
    public String getEmpName() {
        return name;
    }
    
    @Override
    public String toString() {
    	return "Employee [Id=" + id + ", Name=" + name + ", Address=" + address + "]";
    }
       
}
