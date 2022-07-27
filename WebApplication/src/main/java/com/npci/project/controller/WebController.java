package com.npci.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.npci.project.service.WebServices;
@RestController
@RequestMapping("/web")
public class WebController {
	
	@Autowired
	private WebServices services;
	
	@GetMapping("/display")
	public String display() {
		return "Hello....";
	}
	
	@GetMapping("/service")
	public String diplayFromService() {
		return services.displayService();
	}

}
