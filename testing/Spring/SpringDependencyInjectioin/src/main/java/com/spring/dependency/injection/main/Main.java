package com.spring.dependency.injection.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.dependency.injection.bean.Restaurant;

public class Main {

	public static void main(String[] args) {
		System.out.println("Welcome to Dependency Injection.");
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		Restaurant restaurant = context.getBean("rRef", Restaurant.class);
		System.out.println(restaurant);
		System.out.println(restaurant.getAddress());
		
		System.out.println("Search Keywords:");
		System.out.println(restaurant.getSearchKeywords());		
	}
}
