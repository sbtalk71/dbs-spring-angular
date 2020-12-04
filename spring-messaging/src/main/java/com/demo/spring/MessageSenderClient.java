package com.demo.spring;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class MessageSenderClient {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		JmsTemplate jmsTemplate = ctx.getBean(JmsTemplate.class);

		jmsTemplate.send(new MessageCreator() {

			public Message createMessage(Session session) throws JMSException {
				
				TextMessage msg = session.createTextMessage();
				msg.setText("Hi from Spring...");
				
				return msg;
			}
		});
		ctx.close();

	}

}
