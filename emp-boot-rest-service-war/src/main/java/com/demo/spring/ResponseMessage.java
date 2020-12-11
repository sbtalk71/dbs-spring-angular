package com.demo.spring;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ResponseMessage {

	private int statusCode;
	private String message;

	public ResponseMessage() {
		// TODO Auto-generated constructor stub
	}

	public ResponseMessage(int statusCode, String message) {
		this.statusCode = statusCode;
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
