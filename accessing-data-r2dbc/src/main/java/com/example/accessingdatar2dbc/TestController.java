package com.example.accessingdatar2dbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class TestController {

	@Autowired
	CustomerRepository repo;
	
	@GetMapping(path="/emp",produces = "application/json")
	public Flux<Customer> findAllCustomers(){
		return repo.findAll();
	}
}
