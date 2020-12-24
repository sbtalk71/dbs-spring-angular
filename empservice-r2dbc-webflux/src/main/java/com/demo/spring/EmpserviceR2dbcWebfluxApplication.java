package com.demo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

import reactor.tools.agent.ReactorDebugAgent;

@SpringBootApplication
@EnableR2dbcRepositories
public class EmpserviceR2dbcWebfluxApplication {

	public static void main(String[] args) {
		ReactorDebugAgent.init();
		SpringApplication.run(EmpserviceR2dbcWebfluxApplication.class, args);
	}

}
