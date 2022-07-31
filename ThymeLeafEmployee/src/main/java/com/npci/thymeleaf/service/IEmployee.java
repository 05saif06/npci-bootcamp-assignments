package com.npci.thymeleaf.service;

import java.util.List;

import com.npci.thymeleaf.entity.Employee;

public interface IEmployee {
	
	public List<Employee> findAllEmployee();
	
	public void saveEmployeeDetails(Employee emp);
	
	public Employee findById(Integer empId);
	
	public void deleteById(int empId);

}
