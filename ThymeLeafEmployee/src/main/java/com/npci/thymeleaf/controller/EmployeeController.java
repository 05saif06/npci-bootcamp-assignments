package com.npci.thymeleaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.npci.thymeleaf.entity.Employee;
import com.npci.thymeleaf.service.IEmployee;

@Controller
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private IEmployee service;

	@GetMapping("/employeeList")
	public String findAll(Model model) {
		List<Employee> emp = service.findAllEmployee();
		model.addAttribute("EMPLOYEE", emp);
		return "empUI/emp.html";
	}

	@GetMapping("/addEmployee")
	public String employeeForm(Model model) {
		model.addAttribute("EMPLOYEE", new Employee());
		return "empUI/empForm.html";
	}

	@PostMapping("/saveEmployee")
	public String saveEmployeeDetails(@ModelAttribute("EMPLOYEE") Employee emp) {
		service.saveEmployeeDetails(emp);
		return "redirect:/api/employeeList";
	}
	@GetMapping("/updateForm")
	public String updateEmployeeDetails(@RequestParam("empId")Integer empId, Model model) {
		Employee emp = service.findById(empId);
		model.addAttribute("EMPLOYEE", emp);
		return "empUI/empForm.html";
	}
	@GetMapping("/deleteForm")
	public String deleteById(@RequestParam("empId") int empId) {
		service.deleteById(empId);
		return "redirect:/api/employeeList";
	}

}
