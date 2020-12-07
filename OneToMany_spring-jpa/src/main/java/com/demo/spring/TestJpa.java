package com.demo.spring;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.demo.jpa.entity.Emp;

@Service
public class TestJpa {

	@PersistenceContext
	EntityManager em;
	
	
	public void testFind() {
		
		Emp e=em.find(Emp.class, 116);
		
		System.out.println(e.getEmpId()+" "+e.getEmpName()+" "+e.getSalary());
	}
}
