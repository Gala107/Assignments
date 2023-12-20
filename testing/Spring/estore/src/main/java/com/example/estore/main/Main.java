package com.example.estore.main;

import com.example.estore.bean.Connection;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;

public class Main {

	public static void main(String[] args) {
		// IOC: Inversion Of Control
		System.out.println("Welcome to Spring Core Bean Factory IOC!");
		
		// Traditional approach to create an object
		/*
		Connection con1 = new Connection();
		con1.setUrl("jdbc:mysql://localhost/estore");
		con1.setUsername("john");
		con1.setPassword("123");
		System.out.println("con1 values: " + con1);
		*/
		
		// IOC approach to user Spring Framework IOC Container
		// Developer doesn't create an object, rather configures it
		
		// BeanFactory IOC Container - responsible for managing objects from construction till destruction
		Resource resource = new ClassPathResource("beans.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		System.out.println("BeanFactory IOC Container is created.");
		
		// Get the reference of the beans from the BeanFactory IOC Container
		Connection con1 = (Connection) factory.getBean("con1");	
		Connection con2 = factory.getBean("con2", Connection.class);
		// No constructor is ran in this case. Object is re-used.
		// Object is kind of like Singleton. Only one object is created per bean config.
		Connection con3 = factory.getBean("con1", Connection.class);
		
		// Confirming that con1 and con3 poin to the same object.
		System.out.println("con1 hash code: " + con1.hashCode());
		System.out.println("con3 hash code: " + con3.hashCode());
		System.out.println("con2 hash code: " + con2.hashCode());
	}
}
