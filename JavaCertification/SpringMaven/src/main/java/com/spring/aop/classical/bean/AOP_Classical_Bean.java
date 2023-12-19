package com.spring.aop.classical.bean;

public class AOP_Classical_Bean {
	public void validate() {
		System.out.println("[BasicBean] Validation from Basic Bean");
	}
	
	public void validate(int age) throws Exception {
		if(age < 18) {
			throw new ArithmeticException("[BasicBean] Age is not valid.");
		} else {
			System.out.println("[BasicBean] Age Confirmed!");
		}
	}
}
