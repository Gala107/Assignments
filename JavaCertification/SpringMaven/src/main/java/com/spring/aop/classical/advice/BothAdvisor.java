package com.spring.aop.classical.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class BothAdvisor implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("[BothAdvisor] Before Method...");
		invocation.proceed();
		System.out.println("[BothAdvisor] After Method...");
		return null;
	}
}
