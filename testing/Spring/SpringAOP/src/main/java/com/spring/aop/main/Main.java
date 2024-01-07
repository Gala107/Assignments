package com.spring.aop.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.aop.bean.Product;

public class Main {

	public static void main(String[] args) {
			
		System.out.println("Welcome to Spring AOP - Aspect Oriented Programming.");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Product product = context.getBean("productProxy", Product.class);
		// System.out.println(product);
		
		product.purchaseProduct("Home", "6 pm", "john@me.com");
		
		// ProxyFactoryBean : Configure this class for our bean object with Advices
		// We need to configure below attributes:
		// 1. target
		// 2. interceptorNames
	}
}
