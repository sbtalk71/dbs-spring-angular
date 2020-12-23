package com.demo.spring.controllers;

import java.time.Duration;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class TestController {
	
	@GetMapping(path="/names",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<String> getNames(){
		Flux<String> namesFlux=Flux.just("Shantanu","Pavan","Arun","Chandra","Pretham","Raja");
		return namesFlux;
	}
	
	@GetMapping(path="/pulse",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<String> getPulse(){
		Flux<String> namesFlux=Flux.just("Shantanu","Pavan","Arun","Chandra","Pretham","Raja");
		Flux<Long> pulseData=Flux.interval(Duration.ofSeconds(2));
		Flux<String> names2=Flux.zip(namesFlux, pulseData,(s,t)->(s));
		return names2;
	}
	
	@GetMapping(path="/generate",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Long> getData(){
		Flux<Long> data=Flux.generate(()->1, (state,sink)->{
			
			sink.next(state+10L);
			return state+1;
		});
		Flux<Long> pulseData=Flux.interval(Duration.ofSeconds(2));
		Flux<Long> data2=Flux.zip(data, pulseData,(s,t)->(s));
	
		return data2;
	}

}
