package com.spring.autowired.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.autowired.bean.User;

public class Main {

	public static void main(String[] args) {
		System.out.println("welcome to Spring Frameword Autowired Demo.");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		User uRef = context.getBean("user", User.class);
		System.out.println(uRef);		
	}
}
