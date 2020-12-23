package com.demo.spring.controllers;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.EmpMongoRepository;
import com.demo.spring.entity.Emp;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class EmpReactiveRestController {

	@Autowired
	EmpMongoRepository repo;
	@PostMapping(path="/emp/save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<Emp> save(@RequestBody Emp e){
		return repo.save(e);
	}
	
	@GetMapping(path="/emp/find/{id}")
	public Mono<Emp> findOneEmp(@PathVariable("id") int id){
		return repo.findById(id);
	}
	
	
	@GetMapping(path="/emp/list", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Emp> listAll(){
		
		
		//Flux<Long> pulseData=Flux.interval(Duration.ofSeconds(2));
		//Flux<Emp> empList=Flux.zip(repo.findAll(), pulseData,(s,t)->(s));
		return repo.findAll().delayElements(Duration.ofSeconds(2));
	}
	
	
	@GetMapping("/init")
	public void initData() {
		System.out.println("Initializing Data..");
		repo.deleteAll();
		String[] names= {"Shantanu","Rohan","Kuladeep","Geetha","Ankitha","Chirayu","Abhinay","Parvathi","Anand"};
		for(int i=0;i<names.length-1;i++) {
			System.out.println("data Saved "+i);
			repo.save(new Emp(i, names[i+1], "city"+i, 40000+i)).subscribe();
		}
	}
}
