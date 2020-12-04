package com.demo.spring.controllers;

import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.spring.entity.Emp;

@Controller

public class LoginController {

	/*
	 * @RequestMapping(path = "/login", method = RequestMethod.GET) public String
	 * getLoginPage() { return "login"; }
	 */

	@RequestMapping(path = "/process_login", method = RequestMethod.POST)
	public ModelAndView processForm(@RequestParam("username") String name, @RequestParam("password") String pwd) {
		ModelAndView mv = new ModelAndView();
		if (name.equals(pwd)) {
			mv.setViewName("success");
			mv.addObject("loggedInUser", name);
		} else {
			throw new RuntimeException("login failed..");
			
		}
		return mv;
	}
	
	/*
	 * @PostMapping("/register_emp") public ModelAndView processRegisterEmp(
	 * 
	 * @RequestParam("empId") String id,
	 * 
	 * @RequestParam("name") String name,
	 * 
	 * @RequestParam("city") String city,
	 * 
	 * @RequestParam("salary") String salary) {
	 * 
	 * ModelAndView mv = new ModelAndView(); HashMap<String, String> emp=new
	 * HashMap<>(); emp.put("id", id); emp.put("name", name); emp.put("city", city);
	 * emp.put("salary", salary);
	 * 
	 * mv.addObject("emp",emp); mv.setViewName("reg_success"); return mv; }
	 */
	
	@PostMapping("/register_emp")
	public ModelAndView processRegisterEmp(@ModelAttribute Emp e) {
		
		ModelAndView mv = new ModelAndView();
		
		
		mv.addObject("emp",e);
		mv.setViewName("reg_success");
		return mv;
	}

	@ExceptionHandler(RuntimeException.class)
	public String handleLoginFailure(RuntimeException ex) {
		//ex.printStackTrace();
		//System.out.println(ex.getMessage());
		return "failure";
		//return ResponseEntity.status(401).build();
	}
}
