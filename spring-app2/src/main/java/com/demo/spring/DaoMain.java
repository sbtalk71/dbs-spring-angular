package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DaoMain {

	public static void main(String[] args) {
		
		ApplicationContext ctx= new ClassPathXmlApplicationContext("context.xml");
		
		//EmpService service=(EmpService)ctx.getBean("eService");
		
		EmpService service=ctx.getBean(EmpService.class);
		
		System.out.println(service.register(100, "Pavan", "Hyderabad", 80000));

	}

}
