package com.npci.project.employee.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.npci.project.employe.entity.Employee;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Employee> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Employee> query = currentSession.createQuery("select e from Employee e", Employee.class);
		List<Employee> empList = query.getResultList();
		return empList;
	}

	@Override
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		return currentSession.get(Employee.class, id);
	}

	@Transactional
	public void saveEmployeeDetails(Employee emp) {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.save(emp);

	}

	@Transactional
	public void deleteById(int empId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Employee> query = currentSession.createQuery("delete  from Employee  where empno = :employeeId");
		query.setParameter("employeeId", empId);
		query.executeUpdate();

	}

	@Override
	public void updateEmployeeDetails(Employee emp) {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(emp);
		
		
	}

}
