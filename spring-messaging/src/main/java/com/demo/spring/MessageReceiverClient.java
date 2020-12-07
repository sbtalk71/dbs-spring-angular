
package com.demo.spring;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class MessageReceiverClient {

	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		JmsTemplate jmsTemplate = ctx.getBean(JmsTemplate.class);

		//jmsTemplate.setSessionAcknowledgeMode(Session.CLIENT_ACKNOWLEDGE);
		TextMessage tm = (TextMessage) jmsTemplate.receive();

		System.out.println(tm.getText());
		
		System.in.read();
		
		//tm.acknowledge();
		
		

	}

}
