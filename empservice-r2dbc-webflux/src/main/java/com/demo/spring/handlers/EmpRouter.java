package com.demo.spring.handlers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class EmpRouter {

	
	@Bean
	public RouterFunction<ServerResponse> appRoutes(EmpDataHandler handler){
		return RouterFunctions.route(RequestPredicates.GET("/emp1/find/{id}"), handler::getById)
				.andRoute(RequestPredicates.GET("/emp1/all"), handler::findAllEmps)
				.andRoute(RequestPredicates.POST("/emp1/save"), handler::save)
				.andRoute(RequestPredicates.PUT("/emp1/update"), handler::update)
				.andRoute(RequestPredicates.DELETE("/emp1/delete"), handler::delete);
				
	}
	
}
