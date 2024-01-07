package com.spring.jdbc.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.jdbc.db.DbConnector;
import com.spring.jdbc.model.Dish;

public class Main {

	public static void main(String[] args) {
	
		System.out.println("Spring JDBC");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		DbConnector db = context.getBean("db", DbConnector.class);
		
		Dish dish = new Dish(0, "Noodles", 200);
		Dish dish2 = new Dish(0, "Burger", 100);
		Dish dish3 = new Dish(0, "Pizza", 500);
		
		db.insertDish(dish);
		db.insertDish(dish2);
		db.insertDish(dish3);
		
		db.fetchAllDishes();		
	}
}
