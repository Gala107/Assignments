package com.spring.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.bean.Hello;
import com.spring.bean.Employee;

public class SpringMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		// works only if one bean with the same class name is configured in beans.xml
		// Hello helloBean = context.getBean(Hello.class);

		Hello helloBean1 = (Hello) context.getBean("h1");
		Hello helloBean2 = (Hello) context.getBean("h2");
		System.out.println(helloBean1.getMessage());
		System.out.println(helloBean2.getMessage());
		System.out.println("**************");
		
		Employee e = (Employee) context.getBean("e1");
		System.out.println(e);
		Employee e2 = (Employee) context.getBean("e2");
		System.out.println(e2);
	}
}
