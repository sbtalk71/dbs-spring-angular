package com.demo.spring.dao.impl;

import org.springframework.stereotype.Repository;

import com.demo.spring.dao.EmpDao;
import com.demo.spring.entity.Emp;


@Repository
public class EmpDaoMockImpl implements EmpDao {

	public String save(Emp e) {

		return "Mock: Emp saved with id " + e.getEmpid();
	}
	
	
}
