package com.demo.spring;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.demo.spring.entity.Emp;

public interface EmpMongoRepository extends ReactiveMongoRepository<Emp, Integer> {

}
