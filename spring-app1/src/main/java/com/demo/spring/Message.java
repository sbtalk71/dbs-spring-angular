package com.demo.spring;

public class Message {
	private String header;
	private String body;

	public Message() {
		System.out.println("Setter Injected Bean created...");
	}

	public Message(String header, String body) {
		System.out.println("Constructore Injected Bean created");
		this.header = header;
		this.body = body;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

}
