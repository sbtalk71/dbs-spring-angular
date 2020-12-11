package com.demo.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="EMP")
public class Emp {
	@Id
	@Column(name="EMPNO")
	private int empid;
	
	@Column(name="NAME")
	private String empName;
	
	@Column(name="ADDRESS")
	private String city;
	
	@Column(name="SALARY")
	private double salary;
	
	public Emp() {
		
	}

	public Emp(int empid, String empName, String city, double salary) {
		this.empid = empid;
		this.empName = empName;
		this.city = city;
		this.salary = salary;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
}
