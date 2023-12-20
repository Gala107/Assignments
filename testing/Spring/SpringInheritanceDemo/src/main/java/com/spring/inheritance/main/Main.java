package com.spring.inheritance.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.inheritance.bean.Pizza;

public class Main {

	public static void main(String[] args) {
		System.out.println("Welcome to Spring Core Inheritance Configuration.");
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		Pizza pRef = context.getBean("pizza", Pizza.class);
		System.out.println(pRef);
	}
}
