package com.npci.project.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.npci.project.employe.entity.Employee;
import com.npci.project.employee.repository.IEmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private IEmployeeService service;

	@GetMapping("/showAll")
	public List<Employee> findAll() {
		return service.findAll();
	}

	@GetMapping("/employees/{empId}")
	public Employee showById(@PathVariable int empId) throws Exception {
		Employee emp = service.findById(empId);
		if (emp == null) {
			throw new RuntimeException("Employee ID : " + empId + " details not found ");
		}
		return emp;
	}
	@PostMapping("/addNewEmployees")
	public String saveEmployeeDetails(@RequestBody Employee emp) {
		emp.setEmpNo(0);
		service.saveEmployeeDetails(emp);
		return "Added Successfull";
	}
	@PutMapping("/updateEmployees")
	public String updateEmployeeDetails(@RequestBody Employee emp) {
		service.updateEmployeeDetails(emp);
		return "Updated Successfully";
	}
	
	@DeleteMapping("/deleteEmployee/{empId}")
	public String deleteEmployeeDetails(@PathVariable int empId) {
		Employee emp = service.findById(empId);
		if (emp == null) {
			throw new RuntimeException("Employee ID : " + empId + " details not found ");
		}
		service.deleteById(empId);
		return "Deleted Successfull";
	}

}
