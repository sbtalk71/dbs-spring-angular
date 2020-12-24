package clients;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

public class DeleteReactiveClient {

	public static void main(String[] args) throws Exception{
		
		WebClient client=WebClient.create();
		
		
		client.delete()
				.uri("http://localhost:8080/emp/delete?id=106")
				.accept(MediaType.TEXT_PLAIN)
				//.retrieve()
				.exchange()
				.subscribe(response->System.out.println(response.statusCode()));

		
		
		Thread.sleep(10000);
	}

}
