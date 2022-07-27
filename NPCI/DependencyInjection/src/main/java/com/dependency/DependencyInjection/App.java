package com.dependency.DependencyInjection;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        BeanFactory factory =  new AnnotationConfigApplicationContext(AnimalComponentScan.class);
        
        AnimalUtility animalUtility = (AnimalUtility) factory.getBean("animalUtility");
        animalUtility.setAnimal((Lion) factory.getBean("lion"));
        animalUtility.eat();
    }
}

