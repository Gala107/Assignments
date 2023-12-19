package com.spring.aop.aspectj.bean;

public class AOP_AspectJ_Bean {
	public void validate() {
		System.out.println("[AspectJBean] Validation from Basic Bean");
	}

	public void validate(int age) throws Exception {
		if (age < 18) {
			throw new ArithmeticException("[AspectJBean] Age is not valid.");
		} else {
			System.out.println("[AspectJBean] Age Confirmed!");
		}
	}
}
