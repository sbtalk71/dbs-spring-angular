package com.demo.spring;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import com.demo.spring.dao.EmpDao;
import com.demo.spring.dao.impl.EmpDaoMockImpl;

//@Component
@Configuration
@ComponentScan(basePackages = "com.demo.spring")
@PropertySource("messages.properties")
public class AppConfig {

	@Bean()
	public EmpDao mydaoImpl() {
		return new EmpDaoMockImpl();
	}
	
	
}
