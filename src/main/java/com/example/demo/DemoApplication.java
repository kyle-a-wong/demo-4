package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

import reactor.core.publisher.Hooks;

@EnableR2dbcRepositories
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
//		Hooks.enableAutomaticContextPropagation();
		SpringApplication.run(DemoApplication.class, args);
	}
}
