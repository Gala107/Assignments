package com.spring.aop.aspectj.aspect.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.aop.aspectj.bean.AOP_AspectJ_Bean;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		AOP_AspectJ_Bean bean = (AOP_AspectJ_Bean) context.getBean("aab");
		bean.validate();
		try {
			bean.validate(13);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
