package com.npci.project.employee.repository;

import java.util.List;

import com.npci.project.employe.entity.Employee;

public interface IEmployeeService {

	public List<Employee> findAll();

	public Employee findById(int id);
	
	public void saveEmployeeDetails(Employee emp);
	
	public void updateEmployeeDetails(Employee emp);
	
	public void deleteById(int empId);

}