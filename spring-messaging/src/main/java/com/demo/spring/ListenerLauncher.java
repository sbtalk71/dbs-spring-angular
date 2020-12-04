package com.demo.spring;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class ListenerLauncher {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(ListenerConfig.class);
		System.out.println("Listener Waiting for messages..");

	}

}
