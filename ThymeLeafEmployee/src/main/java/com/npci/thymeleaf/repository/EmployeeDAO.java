package com.npci.thymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.npci.thymeleaf.entity.Employee;
@Repository
public interface EmployeeDAO extends JpaRepository<Employee,Integer>{

}
