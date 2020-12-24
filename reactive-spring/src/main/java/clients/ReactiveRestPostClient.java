package clients;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import com.demo.spring.entity.Emp;

import reactor.core.publisher.Mono;

public class ReactiveRestPostClient {

	public static void main(String[] args) throws Exception{
		WebClient client=WebClient.create();
		Emp emp= new Emp(200, "Scott", "Bangalore", 45000);
		client.post()
				.uri("http://localhost:8080/emp/save")
				.accept(MediaType.APPLICATION_JSON)
				.header("Content-Type", MediaType.APPLICATION_JSON_VALUE)
				.body(Mono.just(emp), Emp.class)
				.retrieve()
				.bodyToMono(String.class)
				.subscribe(System.out::println);
		
		Thread.sleep(Long.MAX_VALUE);
	}

}
