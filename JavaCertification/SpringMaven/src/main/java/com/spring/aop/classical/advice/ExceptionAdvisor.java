package com.spring.aop.classical.advice;

import org.springframework.aop.ThrowsAdvice;

public class ExceptionAdvisor implements ThrowsAdvice{
	public void afterThrowing(Exception e) {
		System.out.println("[ExceptionAdvisor] additional concern if exception occurs: " + e.toString());
	}
}
