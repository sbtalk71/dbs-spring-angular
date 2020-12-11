package com.demo.spring;

public class EmpNotFoundException extends RuntimeException {

	public EmpNotFoundException(long id) {
		super(id+"");
	}
}
