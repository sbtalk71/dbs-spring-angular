package com.demo.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ADDRESSES")
public class Address {

	@Id
	@Column(name="DOORNO")
	private String doorNo;
	
	@Column(name="STREET")
	private String street;
	
	@Column(name="PIN")
	private String pinCode;

	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(String doorNo, String street, String pinCode) {
		this.doorNo = doorNo;
		this.street = street;
		this.pinCode = pinCode;
	}

	public String getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

}
