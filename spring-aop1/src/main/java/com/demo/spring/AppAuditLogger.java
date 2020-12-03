package com.demo.spring;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AppAuditLogger {

	@Pointcut("execution(* com.demo.spring.*.*eg*(..))")
	public void pcut() {
	}

	@Before("pcut()")
	public void logBefore() {
		System.out.println("Logging Before: Register Employee started..");
	}

	@AfterReturning("pcut()")
	public void logAfter() {
		System.out.println("Logging After: Employee Registered Successfully...");
	}

	@AfterThrowing(throwing = "ex", pointcut = "pcut()")
	public void afterThrowing(RuntimeException ex) {
		System.out.println("Exception Handled is " + ex);
	}

	@After("pcut()")
	public void clean() {
		System.out.println("Resources cleaned...");
	}
}
