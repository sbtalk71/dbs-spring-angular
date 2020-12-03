package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.demo.spring.dao.EmpDao;
import com.demo.spring.entity.Emp;

@Service
public class EmpService {

	@Autowired
	private EmpDao dao;
	
	//@Autowired
	//private AppAuditLogger logger;
	
	public String register(int id, String name, String city, double sal) {
		//logger.logBefore();
		String response = dao.save(new Emp(id, name, city, sal));
		///logger.logAfter();
		return response;
	}
	
	
	public void deRegisterEmp() {
		System.out.println("Emp De registered...");
	}
	
	
}
