package com.demo.spring;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.entity.Emp;
import com.demo.spring.repo.EmpRepository;

@RestController
public class EmpRestController {

	@Autowired
	private EmpRepository repo;

	@GetMapping(path = "/emp/find/{empid}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity findOne(@PathVariable("empid") int id) {

		Optional<Emp> empOp = repo.findById(id);
		if (empOp.isPresent()) {
			return ResponseEntity.ok(empOp.get());
		} else {
			//ResponseMessage message=new ResponseMessage(404,"EMP with the Given ID not found");
			///return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
			//return ResponseEntity.ok(message);
			throw new EmpNotFoundException(id);
			
		}
	}
	@GetMapping(path="/emp/list",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<ListWrapper> listAll(){
		
		List<Emp> empList=repo.findAll();
		ListWrapper wrapper=new ListWrapper();
		wrapper.setEmps(empList);
		return ResponseEntity.ok(wrapper);
	}
	
	@PostMapping(path="/emp/save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity save(@RequestBody Emp e) {
		
		if(repo.existsById(e.getEmpid())) {
			ResponseMessage message=new ResponseMessage(000,"EMP with the Given ID already exists");
			return ResponseEntity.ok(message);
		}else {
			repo.save(e);
			ResponseMessage message=new ResponseMessage(201,"EMP with the Given ID saved successfully");
			return ResponseEntity.ok(message);
		}
	}
}
