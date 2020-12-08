package com.demo.spring.entity;

public class Emp {
	private int empId;
	private String empName;
	private String city;
	private double salary;
	
	public Emp() {
		
	}

	public Emp(int empid, String empName, String city, double salary) {
		this.empId = empid;
		this.empName = empName;
		this.city = city;
		this.salary = salary;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empid) {
		this.empId = empid;
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
