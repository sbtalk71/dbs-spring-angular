package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");

		
		  Message message = (Message) ctx.getBean("msg1");
		  
		  System.out.println(message.getHeader() + " " + message.getBody());
		  message.setBody("No Lunch today...");
		  
		
		  Message message1 = (Message) ctx.getBean("msg1");
		  
		  System.out.println(message1.getHeader() + " " + message1.getBody());
		  System.out.println("Is Singletone? : "+(message==message1));
		 
		 

	}

}
