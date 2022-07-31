package com.npci.thymeleaf.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.npci.thymeleaf.entity.Employee;
import com.npci.thymeleaf.repository.EmployeeDAO;
@Service
public class EmployeeServiceImpl implements IEmployee{
	@Autowired
	private EmployeeDAO dao;

	@Override
	public List<Employee> findAllEmployee() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public void saveEmployeeDetails(Employee emp) {
		// TODO Auto-generated method stub
		dao.save(emp);
	}

	@Transactional
	public Employee findById(Integer empId) {
		// TODO Auto-generated method stub
		Optional<Employee> result = dao.findById(empId);
		Employee emp = null;
		if(result.isPresent()) {
			emp = result.get();
		}
		return emp;
		
	}

	@Transactional
	public void deleteById(int empId) {
		// TODO Auto-generated method stub
		dao.deleteById(empId);
		
	}

	

}
