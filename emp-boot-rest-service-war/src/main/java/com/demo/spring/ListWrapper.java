package com.demo.spring;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.demo.spring.entity.Emp;

@XmlRootElement(name = "empList")
public class ListWrapper {

	
	private List<Emp> emps;

	@XmlElement(name="emp")
	public List<Emp> getEmps() {
		return emps;
	}

	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}
	
}
