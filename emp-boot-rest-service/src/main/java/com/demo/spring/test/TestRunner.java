package com.demo.spring.test;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestRunner implements CommandLineRunner {
public TestRunner() {
	System.out.println("The TestRunner Bean Created..");
}
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello from Spring Boot");

	}

}
