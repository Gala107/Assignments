package com.spring.aop.bean;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class BeforeAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println();

		if (method.getName().equals("purchaseProduct")) {
			System.out.println("[BeforeAdvice] before(...) is executed " + method.getName());
			System.out.println();

			// 1. Validate the Stock | PRE PROCESSING
			System.out.println("[BeforeAdvice] - Validating Stock...");
			Product product = (Product) target;
			if(product.getStock() < 0) {
				product.setCanBuy(false);
				System.out.println("[BeforeAdvice] - We are Out Of Stock for " + product.getName() + "...");
			} else {
				product.setCanBuy(true);
				System.out.println("[BeforeAdvice] - Initiating Transaction for amount of " + product.getPrice() + "...");
			}
		}
		System.out.println();
	}
}
