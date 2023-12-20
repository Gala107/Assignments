package com.spring.application.context.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class PostProcessor implements BeanPostProcessor{

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("[PostProcessor] Before Initialization is executed for Bean: " + beanName);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		Connection con = (Connection) bean;
		String password = con.getPassword();
		con.setPassword(password.replace("6", "@"));
		System.out.println("[PostProcessor] After Initialization is executed for Bean: " + beanName);
		return bean;
	}	
}
