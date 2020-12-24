package clients;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

public class ReactiveRestGetClient {

	public static void main(String[] args) throws Exception{
		WebClient client=WebClient.create();
		client.get()
				.uri("http://localhost:8080/emp/find/200")
				.accept(MediaType.TEXT_EVENT_STREAM)
				.retrieve()
				.bodyToMono(String.class)
				.subscribe(System.out::println);
		
		Thread.sleep(Long.MAX_VALUE);
	}

}
