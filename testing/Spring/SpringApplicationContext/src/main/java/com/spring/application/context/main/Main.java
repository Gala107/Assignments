package com.spring.application.context.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.application.context.bean.Connection;

public class Main {

	public static void main(String[] args) {

		System.out.println("Welcome to Spring Core IOC with Application Context.");
		// Bean objects are instantiated at line below
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("Application Context IOC Container is created.");

		// Bean object is already created above vs BeanFactory where object is created
		// when .getBean(...) is called.
		//Connection c1 = (Connection) context.getBean("con1");
		Connection c2 = context.getBean("con2", Connection.class);
		//Connection c3 = context.getBean("con1", Connection.class);

		// Confirming that con1 and con3 poin to the same object.
		//System.out.println("con1 hash code: " + c1.hashCode());
		//System.out.println("con3 hash code: " + c3.hashCode());
		System.out.println("c2 is: " + c2 + " and hashcode is: " + c2.hashCode());
		
		ClassPathXmlApplicationContext c = (ClassPathXmlApplicationContext) context;
		// Closing context. Shutting down IOC Container.
		// Bean's destroy method will be called.
		c.close();
	}
}
