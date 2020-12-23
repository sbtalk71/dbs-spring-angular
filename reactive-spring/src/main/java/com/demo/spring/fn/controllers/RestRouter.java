package com.demo.spring.fn.controllers;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Component
public class RestRouter {

	@Bean
	public RouterFunction<ServerResponse> testRoutes(MyRestHandler handler){
		
		return RouterFunctions.route(RequestPredicates.GET("/nameTicker"),handler::getPulse);
	}
}
