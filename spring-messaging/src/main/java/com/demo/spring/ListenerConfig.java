package com.demo.spring;

import java.util.Arrays;

import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

//@Configuration
@ComponentScan(basePackages = "com.demo.spring")
@EnableJms

public class ListenerConfig {

	@Bean
	public ActiveMQConnectionFactory connectionFactory() {
		ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory();
		cf.setBrokerURL("tcp://localhost:61616");
		cf.setTrustedPackages(Arrays.asList("com.demo.spring"));
		return cf;
	}
	
	@Bean
	public DefaultMessageListenerContainer messageListerContainer() {
		DefaultMessageListenerContainer container= new DefaultMessageListenerContainer();
		container.setConnectionFactory(connectionFactory());
		container.setDestinationName("demoQueue");
		container.setMessageListener(new TestMessageListener());
		
		return container;
	}
	
	
	
}
