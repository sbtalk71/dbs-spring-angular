package com.demo.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.demo.spring.entity.Emp;

import reactor.core.publisher.Mono;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmpserviceR2dbcWebfluxApplicationTests {

	@Autowired
	private WebTestClient webTestClient;
	
	@Test
	public void testGetById() {
		webTestClient.get().uri("/emp1/find/22")
			.accept(MediaType.APPLICATION_JSON)
			.exchange()
			.expectStatus().isOk()
			.expectBody()
			.consumeWith(resp->org.assertj.core.api.Assertions.assertThat(resp.getResponseBody()).isNotNull());
	}

	@Test
	public void testGetAll() {
		webTestClient.get().uri("/emp1/all")
			.accept(MediaType.APPLICATION_JSON)
			.exchange()
			.expectStatus().isOk()
			.expectHeader().contentType(MediaType.APPLICATION_JSON)
			.expectBodyList(Emp.class);
			//.consumeWith(resp->org.assertj.core.api.Assertions.assertThat(resp.getResponseBody()).isNotNull());
	}
	
	@Test
	public void testSave() {
		webTestClient.post().uri("/emp1/save")
			.accept(MediaType.APPLICATION_JSON)
			.contentType(MediaType.APPLICATION_JSON)
			.body(Mono.just(new Emp("Test","Test",10000)),Emp.class)
			.exchange()
			.expectStatus().isOk()
			.expectBody()
			.jsonPath("$.name").isNotEmpty()
			.jsonPath("$.name").isEqualTo("Test")
			.consumeWith(resp->org.assertj.core.api.Assertions.assertThat(resp.getResponseBody()).isNotNull());
	}
}
