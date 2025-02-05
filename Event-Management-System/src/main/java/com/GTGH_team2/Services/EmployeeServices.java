package com.GTGH_team2.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.GTGH_team2.Entities.Employee;



//The EmployeeServices class handles the employees.It adds,deletes and updates the employee.
//
@Service
public class EmployeeServices {
	
	// List to store all the Employees
	private List<Employee> employees = new ArrayList<Employee>();
	

	// This method adds an Employee to the employees list
	public List<Employee> addEmployee(Employee employee) {
		int newId = 1;
		if(employees.size() > 0) {
			newId = employees.get(employees.size() - 1).getId()+1;
		}
		if(!employees.contains(employee)) {
			employees.add(employee);
			employee.setId(newId);
		}
			
		return employees;
	}
	
	// This method returns the employees list
	public List<Employee> getAllEmployees() {
		return employees;
	}
	
	// This method removes an Employee to the employees list
	public List<Employee> removeEmployee(Integer id) {
		employees.removeIf(employee -> employee.getId() == id);
		return employees;
	}
	
	// This method updates the parameters of an Employee
	public List<Employee> updateEmployee(Integer id, String newName, String newSurname, String newEmail) {
		for (Employee employee : employees) {
			if (id == employee.getId()) {
				if (newName != null)
					employee.setName(newName);
				if (newSurname != null)
					employee.setSurname(newSurname);
				if (newEmail != null)
					employee.setEmail(newEmail);
			}
		}
		return employees;
	}
	
	// This returns the employee by his id
	public Employee getEmployeeById(Integer employeeId) {
		for (Employee employee : employees) {
			if (employeeId == employee.getId()) 
				return employee;
		}
		return null; 
	}

	public List<Employee> addEmployees(List<Employee> employeeList) {
		for(Employee employee : employeeList){
 			this.addEmployee(employee);
 		}
		return employees;
	}

	
}