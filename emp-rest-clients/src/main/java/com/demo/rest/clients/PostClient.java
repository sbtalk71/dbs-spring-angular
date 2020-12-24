package com.demo.rest.clients;

import java.net.URI;
import java.net.URL;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.demo.spring.entity.Emp;

public class PostClient {

	public static void main(String[] args) throws Exception{
		
		RestTemplate rt=new RestTemplate();
		
	
		HttpHeaders headers=new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		
		Emp emp=new Emp(400, "Vin", "Noida", 45000);
		
		HttpEntity req=new HttpEntity<>(emp,headers);
		
		ResponseEntity<String> response=rt.exchange("http://localhost:8181/emp/save", HttpMethod.POST, req, String.class);
		
		System.out.println(response.getBody());
	}

}
