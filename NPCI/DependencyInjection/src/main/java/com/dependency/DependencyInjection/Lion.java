package com.dependency.DependencyInjection;

import org.springframework.stereotype.Component;

@Component(value = "lion")
public class Lion implements Animal{

	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("Lion Class");
	}

}
