package clients;

import org.springframework.web.reactive.function.client.WebClient;

public class MyReactiveRestClient2 {

	public static void main(String[] args) throws Exception{
		
		WebClient client=WebClient.create();
		
	//client.get();
				//.uri("http://localhost:8080/rest/all")
				//.accept(MediaType.APPLICATION_JSON)
				//.exchange()
				//.map(data->data.bodyToMono(String.class)).map(x->x.block()+"\n").subscribe(data->System.out.println(data));
				//.retrieve();
				//.bodyToFlux(Person.class).subscribe(p->System.out.println(p.getName()));
		
		Thread.sleep(10000);
	}

}
