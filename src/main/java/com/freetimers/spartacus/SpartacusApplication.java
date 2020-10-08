package com.freetimers.spartacus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;

@SpringBootApplication(exclude = {EmbeddedMongoAutoConfiguration.class})
public class SpartacusApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpartacusApplication.class, args);
    }
}
