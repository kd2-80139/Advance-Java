package com.app.dao;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import com.app.pojos.Employee;
import com.app.pojos.EmployeeType;

public interface EmployeeDao {
	public void addEmployee(Employee emp);
	Employee getEmpDetailsById(Integer empId);

	// get all emp details
	List<Employee> getAllEmps();

	// get all emp details by join date n salary
	List<Employee> getAllEmpByJoinDate(LocalDate end);

	// get last names of all emps by emp type
	List<String> getLastNamesByEmpType(EmployeeType type);

	// get selected emp details by emp type
	List<Employee> getAllEmpsByType(EmployeeType type);

//add a method to update emp salary
	String updateEmpSalary(String email, String name);

//bulk updation of salaries
	String bulkUpdateSalaryByJoinDate(LocalDate joinDate, String name);

	// add a method to delete emp details by its id
	String deleteEmpDetailsById(Integer empId);

	String storeImage(Integer empid,String file) throws IOException;
	//String restoreImage();
}
