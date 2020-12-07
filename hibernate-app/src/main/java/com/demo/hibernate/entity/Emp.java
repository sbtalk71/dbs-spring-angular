package com.demo.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EMP")
public class Emp {
	@Id
	@Column(name="EMPNO")
	private int empId;
	
	@Column(name="NAME")
	private String empName;
	
	@Column(name="ADDRESS")
	private String city;
	
	@Column(name="SALARY")
	private double salary;
	
	public Emp() {
		
	}

	public Emp(int empId, String empName, String city, double salary) {
		this.empId = empId;
		this.empName = empName;
		this.city = city;
		this.salary = salary;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
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
