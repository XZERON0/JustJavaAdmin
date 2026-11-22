package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.reightvoid.jja.core.AdminRegistry;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean 
	CommandLineRunner checkJja (AdminRegistry registry)
	{
		return args -> {
			registry.getAll().forEach(model ->
                System.out.printf(
                    "Registered: %s -> %s%n",
                    model.path(),
                    model.entityClass().getSimpleName()
                )
            );
		};
	}
}
