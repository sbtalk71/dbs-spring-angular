package clients;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.demo.spring.entity.Emp;

import reactor.core.publisher.Mono;

public class PutReactiveClient {

	public static void main(String[] args) throws Exception{
		
		WebClient client=WebClient.create();
		
		Emp e= new Emp(105, "Ranga", "Hyderabad", 78000);
		client.post()
				.uri("http://localhost:8080/emp/save")
				.accept(MediaType.APPLICATION_JSON)
				.header("Content-Type", "application/json")
				.body(Mono.just(e), Emp.class)
				.retrieve()
				.bodyToMono(Emp.class)
				.subscribe(data->System.out.println(data));

		
		
		Thread.sleep(10000);
	}

}
