package com.demo.spring;

import org.mariadb.r2dbc.MariadbConnectionConfiguration;
import org.mariadb.r2dbc.MariadbConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.r2dbc.connectionfactory.init.ConnectionFactoryInitializer;
import org.springframework.data.r2dbc.connectionfactory.init.ResourceDatabasePopulator;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

import io.r2dbc.spi.ConnectionFactory;

@SpringBootApplication
@EnableR2dbcRepositories
public class R2dbcReactiveEmpServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(R2dbcReactiveEmpServiceApplication.class, args);
		
		
	}
/*
	@Bean
	public MariadbConnectionFactory connectionFactory() {
		MariadbConnectionConfiguration conf=	MariadbConnectionConfiguration.builder()
        .host("127.0.0.1")
        .port(3306)
        .username("root")
        .password("root")
        .database("springdb")
        .build();
		return new MariadbConnectionFactory(conf);
	}
	*/
	
}
