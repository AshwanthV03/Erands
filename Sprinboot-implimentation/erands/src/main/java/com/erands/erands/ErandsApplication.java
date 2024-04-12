package com.erands.erands;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
//@ComponentScan("com.java.controllers")
public class ErandsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErandsApplication.class, args);
	}

}
