package com.demo.spring;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.demo.spring.dao.EmpDao;
import com.demo.spring.entity.Emp;

//@Component
@Service

public class EmpService {

	@Autowired
	@Qualifier("mydaoImpl")
	private EmpDao dao;
	
	@Value("${country}")
	private String country;

	
	public String register(int id, String name, String city, double sal) {

		System.out.println("Registering Employee in "+this.country);
		String response = dao.save(new Emp(id, name, city, sal));
		return response;
	}
	
	@PostConstruct
	public void init() {
		System.out.println("bean initialized...");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("bean willbe destroyed now...");
	}
}
