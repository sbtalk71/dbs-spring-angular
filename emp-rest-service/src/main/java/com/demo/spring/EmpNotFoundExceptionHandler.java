package com.demo.spring;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class EmpNotFoundExceptionHandler {

	@ExceptionHandler(EmpNotFoundException.class)
	@ResponseBody
	//@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public String handleEmpNotFoundException(EmpNotFoundException ex){
		return ex.getMessage();
	}
}
