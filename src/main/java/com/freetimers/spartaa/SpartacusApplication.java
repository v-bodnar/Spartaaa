package com.freetimers.spartaa;

import com.freetimers.spartaa.model.TestEntity;
import com.freetimers.spartaa.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = {EmbeddedMongoAutoConfiguration.class})
public class SpartacusApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpartacusApplication.class, args);
	}

	@Autowired
	TestRepository repository;

	@Bean
	CommandLineRunner runner() {
		return args -> {
			System.out.println(repository.save(new TestEntity()));
			System.out.println(repository.save(new TestEntity()));
			System.out.println(repository.save(new TestEntity()));
			System.out.println(repository.findAll());
		};
	}
}
