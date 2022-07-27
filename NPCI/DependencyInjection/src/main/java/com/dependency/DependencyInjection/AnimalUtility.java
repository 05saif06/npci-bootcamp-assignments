package com.dependency.DependencyInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "animalUtility")
public class AnimalUtility {
	@Autowired
	Animal animal;
	
	public void eat() {
		animal.eat();
	}
	
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	
	

}