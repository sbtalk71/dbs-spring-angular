package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringJpaMain {

	public static void main(String[] args) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(JpaConfig.class);
		
		TestJpa test=ctx.getBean(TestJpa.class);
		
		test.testFind();

	}

}
