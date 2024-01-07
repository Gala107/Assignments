package com.spring.aop.bean;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class AfterAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {

		System.out.println();

		if (method.getName().equals("purchaseProduct")) {
			System.out.println("[AfterAdvice] before(...) is executed " + method.getName());
			Product product = (Product) target;

			// 3. Notification | POST PROCESSING
			System.out.println("[AfterAdvice] - Notifying " + args[2] + " through email with invoice of the amount " + product.price);
			System.out.println("[AfterAdvice] - Product " + product.brand + " " + product.name + " will be delivered at " + args[0] + " by " + args[1]);
			System.out.println("[AfterAdvice] - Notify the Shipment and Dispatch Department for the purchase of " + product.name);
		}
		System.out.println();

	}
}
