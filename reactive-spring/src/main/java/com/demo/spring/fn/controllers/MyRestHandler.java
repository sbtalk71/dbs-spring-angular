package com.demo.spring.fn.controllers;

import java.time.Duration;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class MyRestHandler {

	public Mono<ServerResponse> getPulse(ServerRequest request){
		Flux<String> namesFlux=Flux.just("Shantanu","Pavan","Arun","Chandra","Pretham","Raja");
		Flux<Long> pulseData=Flux.interval(Duration.ofSeconds(2));
		Flux<String> names2=Flux.zip(namesFlux, pulseData,(s,t)->(s));
		return ServerResponse.ok().contentType(MediaType.TEXT_EVENT_STREAM).body(names2, String.class);
	}
}
