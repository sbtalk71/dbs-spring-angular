package com.demo.spring;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.spring.entity.Emp;

@Controller

public class EmpController {

	@GetMapping("/update")
	@ResponseBody
	@Secured("ROLE_ADMIN")
	public String update() {
		return "Data Updated";
	}
	
	@PostMapping("/register")
	//@Secured("ROLE_USER")
	@PreAuthorize("hasRole('ROLE_USER')")
	public String register(@ModelAttribute Emp e) {
		System.out.println("Emp Registered with ID "+e.getEmpId());
		return "result";
	}
}
