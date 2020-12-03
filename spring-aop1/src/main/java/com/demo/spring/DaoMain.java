package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DaoMain {

	public static void main(String[] args) {
		
		ApplicationContext ctx= new AnnotationConfigApplicationContext(AppConfig.class);
		
			
		EmpService service=(EmpService)ctx.getBean("empService");
		
		System.out.println(service.getClass().getName());
		
		//System.out.println(service.register(100, "Pavan", "Hyderabad", 80000));
		service.deRegisterEmp(2);

	}

}
