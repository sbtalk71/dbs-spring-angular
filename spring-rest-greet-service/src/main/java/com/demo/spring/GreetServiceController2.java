package com.demo.spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetServiceController2 {

	// @RequestMapping(path="/greet",method = RequestMethod.GET)
	@GetMapping(path = "/greet/{name}/{age}")
	public String greet(@PathVariable("name") String name, @PathVariable("age") int age) {
		return "HI, " + name + ", you are now " + age;
	}
}
