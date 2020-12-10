package com.demo.spring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

	public InfoController() {
		System.out.println("Info Controller Bean Created");
	}
	@GetMapping("/info")
	public String info() {
		return "This is a test Rest Service";
	}
}
