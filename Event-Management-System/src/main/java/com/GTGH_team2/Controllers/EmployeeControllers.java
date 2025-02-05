package com.GTGH_team2.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.GTGH_team2.Entities.Employee;
import com.GTGH_team2.Services.EmployeeServices;

@RestController
@RequestMapping("employees")
public class EmployeeControllers {

	@Autowired
	EmployeeServices employeeServices;

 	@GetMapping("/allEmployees")
	public List<Employee> getEmployeesAll() {
		return employeeServices.getAllEmployees();	
	}
 	
 	@PostMapping("/add")
	public List<Employee> addEmployee(@RequestBody Employee employee) {
		return employeeServices.addEmployee(employee);
	}
 	
 	
 	@PostMapping("/addMany")
	public List<Employee> addManyEmployee(@RequestBody List<Employee> employee) {
		return employeeServices.addEmployees(employee);
	}
 	
 	
 	@DeleteMapping("/delete")
	public List<Employee> deleteEmployee(@RequestParam Integer id) {
		return employeeServices.removeEmployee(id);
	}
 	
 	@PutMapping("/update")
	public List<Employee> updateEmployee(@RequestParam Integer id , @RequestParam(required = false) String newName,@RequestParam(required = false)  String newSurname,@RequestParam(required = false)  String newEmail ) {
		return employeeServices.updateEmployee(id, newName, newSurname, newEmail );
	}
 	
}
