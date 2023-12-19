package com.spring.aop.aspectj.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AOP_Aspect {
	@Pointcut("execution(* com.spring.aop.aspectj.bean.AOP_AspectJ_Bean.valid*(..))")
	public void v() {
		System.out.println("[AOP_Aspect] Pointcut");
	}
	
	@Before("v()")
	public void beforeMethod(JoinPoint jp) {
		System.out.println("[AOP_Aspect] before method: " + jp.getSignature());
	}
	
	@After("v()")
	public void afterMethod(JoinPoint jp) {
		System.out.println("[AOP_Aspect] after method: " + jp.getSignature());
	}
	
	@Around("v()")
	public Object myAdvice(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("[AOP_Aspect] before of @Around calling actual method");
		Object obj = jp.proceed();
		System.out.println("[AOP_Aspect] after of @Around calling actual method");
		return obj;
	}
	
	@AfterThrowing(
			pointcut = "execution(* com.spring.aop.aspectj.bean.AOP_AspectJ_Bean.*(..))",
			throwing = "error")
	public void myAdvice(JoinPoint jp, Throwable error) {
		System.out.println("[AOP_Aspect] beginning from @AfrerThrowing... ");
		System.out.println("[AOP_Aspect] method signature: " + jp.getSignature());
		System.out.println("[AOP_Aspect] Exception: " + error);
		System.out.println("[AOP_Aspect] end from @AfrerThrowing... ");
	}
}
