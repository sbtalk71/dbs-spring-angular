package com.demo.jpa.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "EMP")
@NamedQueries({
		@NamedQuery(name = "getSomeData", query = "select e.empName,e.salary from Emp e where e.salary between 60000 and 90000") })
public class Emp {
	@Id
	// @GeneratedValue(strategy =GenerationType.AUTO)
	// @SequenceGenerator(sequenceName = "xyz",name = "myseq")
	@Column(name = "EMPNO")
	private int empId;

	@Column(name = "NAME")
	private String empName;

	@Column(name = "ADDRESS")
	private String city;

	@Column(name = "SALARY")
	private double salary;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "EMPNO")
	Set<Address> addresses = new HashSet<>();

	public Emp() {

	}

	public Emp(int empId, String empName, String city, double salary) {
		this.empId = empId;
		this.empName = empName;
		this.city = city;
		this.salary = salary;
	}

	public Emp(String empName, String city, double salary) {
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

	public Set<Address> getAddress() {
		return addresses;
	}

	public void setAddress(Set<Address> addresses) {
		this.addresses = addresses;
	}

}
