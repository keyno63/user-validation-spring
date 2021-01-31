package com.github.keyno.uservalidationspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
public class UserValidationSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserValidationSpringApplication.class, args);
    }

}
