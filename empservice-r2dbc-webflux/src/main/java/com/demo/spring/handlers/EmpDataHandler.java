package com.demo.spring.handlers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.demo.spring.entity.Emp;
import com.demo.spring.repo.EmpCrudRepository;

import reactor.core.publisher.Hooks;
import reactor.core.publisher.Mono;

@Component
public class EmpDataHandler {

	@Autowired
	EmpCrudRepository empRepo;

	public Mono<ServerResponse> getById(ServerRequest request) {
		Hooks.onOperatorDebug();
		int id = Integer.parseInt(request.pathVariable("id"));

		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(
				empRepo.findById(id)
				.switchIfEmpty(Mono.error(new RuntimeException("Not Found"))),Emp.class)
				.onErrorContinue((t,d)->System.out.println(t.getMessage()));

	}

	public Mono<ServerResponse> findAllEmps(ServerRequest request) {

		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(empRepo.findAll(), Emp.class);
	}

	public Mono<ServerResponse> save(ServerRequest request) {

		Mono<Emp> empMono = request.bodyToMono(Emp.class);

		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromPublisher(empMono.flatMap(empRepo::save), Emp.class));
	}

	public Mono<ServerResponse> update(ServerRequest request) {

		Mono<Emp> empMono = request.bodyToMono(Emp.class);

		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromPublisher(empMono.flatMap(empRepo::save), Emp.class));

		/*
		 * .body(empMono.flatMap( e->{empRepo.findById(e.getEmpId()).map(p -> {
		 * p.setName(e.getName()); p.setSalary(e.getSalary()); p.setCity(e.getCity());
		 * return p; }).flatMap(p -> empRepo.save(p)); }),Emp.class);
		 */

	}

	public Mono<ServerResponse> delete(ServerRequest request){
		int id=Integer.parseInt(request.queryParam("id").get());
		
		return ServerResponse.ok()
				.bodyValue(
						empRepo.findById(id)
						.switchIfEmpty(Mono.error(new RuntimeException("Emp Not Found")))
						.flatMap(e -> empRepo.deleteById(id)));

	}
}
