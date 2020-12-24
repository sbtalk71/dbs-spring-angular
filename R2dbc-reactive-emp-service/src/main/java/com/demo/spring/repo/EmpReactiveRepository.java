package com.demo.spring.repo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.demo.spring.entity.Emp;



public interface EmpReactiveRepository extends ReactiveCrudRepository<Emp, Integer> {

}
