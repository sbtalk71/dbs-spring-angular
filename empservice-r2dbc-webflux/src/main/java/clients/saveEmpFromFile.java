package clients;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.BaseStream;

import org.springframework.http.MediaType;

import org.springframework.web.reactive.function.client.WebClient;

import com.demo.spring.entity.Emp;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Hooks;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class saveEmpFromFile {

	public static void main(String[] args) throws Exception{
		Hooks.onOperatorDebug();
		WebClient client=WebClient.create();
		
		Path filePath=Paths.get("emlist.txt");
		Path filePath2=Paths.get("emlist2.txt");
		
		Flux.using(()->Files.lines(filePath),Flux::fromStream,BaseStream::close)
		.mergeWith(
		Flux.using(()->Files.lines(filePath2),Flux::fromStream,BaseStream::close))
		.parallel(4)
		.runOn(Schedulers.elastic())
		.doOnNext(line->{
			String[] data=line.split(" ");
			Emp e=new Emp(data[0], data[1], Double.parseDouble(data[2]));
			System.out.println("Thread processing is "+Thread.currentThread().getName());
			client.post()
			.uri("http://localhost:8080/emp1/save")
			.accept(MediaType.APPLICATION_JSON)
			.header("Content-Type", "application/json")
			.body(Mono.just(e), Emp.class)
			.retrieve()
			.bodyToMono(Emp.class)
			.subscribe(x->System.out.println(x));
		}).log().subscribe();
		

		
		
		Thread.sleep(10000);
	}

}
