package com.demo.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String getLoginPage() {
		return "login";
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String processForm(@RequestParam("username") String name, @RequestParam("password") String pwd) {
		if (name.equals(pwd)) {
			return "success";
		} else {
			return "failure";
		}
	}

}
