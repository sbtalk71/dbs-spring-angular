package com.demo.spring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AroundAppAuditLogger {

	@Pointcut("execution(* com.demo.spring.*.*eg*(..))")
	public void pcut() {
	}

	@Around("pcut()")
	public Object invoke(ProceedingJoinPoint pjp) throws Throwable {
		Object retVal = null;
		try {
			logBefore();
			retVal = pjp.proceed();
			logAfter();
		} catch (Throwable t) {
			t.printStackTrace();
		} finally {
			clean();
		}

		return retVal;
	}

	public void logBefore() {
		System.out.println("Logging Before: Register Employee started..");
	}

	public void logAfter() {
		System.out.println("Logging After: Employee Registered Successfully...");
	}

	public void clean() {
		System.out.println("Resources cleaned...");
	}
}
