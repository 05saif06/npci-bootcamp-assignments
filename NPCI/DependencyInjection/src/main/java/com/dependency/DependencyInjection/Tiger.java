package com.dependency.DependencyInjection;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component(value = "tiger")
@Primary
public class Tiger implements Animal{

	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("Tiger class");
	}

}


