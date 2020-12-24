package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.entity.Emp;
import com.demo.spring.repo.EmpReactiveRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class EmpRestController {

	@Autowired
	private EmpReactiveRepository repo;

	@GetMapping(path = "/emp/find/{id}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Mono<Emp> findOneEmp(@PathVariable("id") int id) {

		repo.findById(id).subscribe(e -> System.out.println(e.getEmpName()));
		
		return repo.findById(id);
	}

	@GetMapping(path = "/emp", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public ResponseEntity<Flux<Emp>> listAll() {
		
		return ResponseEntity.ok(repo.findAll());
	}
}
