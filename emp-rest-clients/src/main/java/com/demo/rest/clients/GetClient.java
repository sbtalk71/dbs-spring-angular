package com.demo.rest.clients;

import java.net.URI;
import java.net.URL;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.demo.spring.entity.Emp;

public class GetClient {

	public static void main(String[] args) throws Exception{
		
		String userCredentials="john:welcome1";
		String encryptedCreds=new String(Base64.encodeBase64(userCredentials.getBytes()));
		System.out.println(encryptedCreds);
		RestTemplate rt=new RestTemplate();
		
	//	HttpHeaders headers=rt.headForHeaders(new URI("http://localhost:8080/emp-rest-service/emp/find/104"));
		
	//	System.out.println(headers);
		HttpHeaders headers=new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.add("Authorization", "Basic "+encryptedCreds);
		
		
		
		HttpEntity req=new HttpEntity<>(headers);
		
		ResponseEntity<Emp> response=rt.exchange("http://localhost:8080/emp-rest-service/emp/find/104", HttpMethod.GET, req, Emp.class);
		
		//ResponseEntity<String> response= rt.getForEntity("http://localhost:8080/emp-rest-service/emp/find/104", String.class);

		System.out.println(response.getBody().getEmpName());
	}

}
