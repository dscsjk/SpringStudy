package com.wind.s10;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAop {
	@Pointcut("within(com.wind.s10.*)")
	public void pointcutMethod() {
		
	}
	
	@Around("pointcutMethod()")
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable  {
		String signatureStr = joinpoint.getSignature().toShortString();
		System.out.println(signatureStr+ " is start.");
		long st = System.currentTimeMillis();
		
		try {
			Object obj = joinpoint.proceed();
			return obj;
		} finally  {
			long et = System.currentTimeMillis();
			System.out.println(signatureStr+ " 경과시간 : " + (et-st));
		}
		
	}
	
	@Before("within(com.wind.s10.*)")
	public void beforeAdvice(JoinPoint joinPoint) {
		System.out.println("####beforeAdvice()");
	}
	
	@After("within(com.wind.s10.*)")
	public void afterAdvice(JoinPoint joinPoint) {
		System.out.println("####afterAdvice()");
	}
	
	@AfterThrowing("within(com.wind.s10.*)")
	public void afterThrowingAdvice(JoinPoint joinPoint) {
		System.out.println("####afterThrowingAdvice()");
	}
	
	@AfterReturning("within(com.wind.s10.*)")
	public void afterReturningAdvice(JoinPoint joinPoint) {
		System.out.println("####afterReturningAdvice()");
	}
}
