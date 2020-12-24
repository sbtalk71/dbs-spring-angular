package com.demo.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.entity.Emp;
import com.demo.spring.repo.EmpCrudRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/emp")
public class EmpReactiveController {

	@Autowired
	EmpCrudRepository empRepo;

	@GetMapping(path = "/find/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<Emp> getById(@PathVariable("id") int id) {
		return empRepo.findById(id)
				.switchIfEmpty(Mono.error(new RuntimeException("Not Found")));
						
				//onErrorContinue((t,d)->System.out.println(t.getMessage()));

	}

	@GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public Flux<Emp> findAllEmps() {

		return empRepo.findAll();
	}

	@PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<Emp> save(@RequestBody Emp e) {

		System.out.println("Recieved : " + e);
		return empRepo.save(e);

	}

	@PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<Emp> update(@RequestBody Emp e) {

		return empRepo.findById(e.getEmpId()).map(p -> {
			p.setName(e.getName());
			p.setSalary(e.getSalary());
			p.setCity(e.getCity());
			return p;
		}).flatMap(p -> empRepo.save(p));

	}

	@DeleteMapping(path = "/delete")
	public Mono<Void> delete(@RequestParam("id") int id) {
		return empRepo.findById(id).switchIfEmpty(Mono.error(new RuntimeException("Emp Not Found")))
				.flatMap(e->empRepo.deleteById(id));
				
				

	}
}
