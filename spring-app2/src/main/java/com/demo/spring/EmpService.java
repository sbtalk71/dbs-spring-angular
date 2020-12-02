package com.demo.spring;

import com.demo.spring.dao.EmpDao;
import com.demo.spring.entity.Emp;

public class EmpService {

	private EmpDao dao;

	public void setDao(EmpDao dao) {
		this.dao = dao;
	}

	public String register(int id, String name, String city, double sal) {

		String response = dao.save(new Emp(id, name, city, sal));
		return response;
	}
}
