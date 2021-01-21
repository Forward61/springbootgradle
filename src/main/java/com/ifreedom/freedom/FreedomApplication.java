package com.ifreedom.freedom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
@EnableAspectJAutoProxy
@ComponentScan("com.ifreedom.freedom.*")
@SpringBootApplication
public class FreedomApplication {

	public static void main(String[] args) {
		SpringApplication.run(FreedomApplication.class, args);

		System.out.println("First Gradle Project 2020");



	}

}
