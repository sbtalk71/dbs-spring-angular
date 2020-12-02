package com.demo.spring.dao.impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.demo.spring.dao.EmpDao;
import com.demo.spring.entity.Emp;

//@Component
@Repository
public class EmpDaoMockImpl2 implements EmpDao {

	public String save(Emp e) {

		return "Mock2: Emp saved with id " + e.getEmpid();
	}
}
