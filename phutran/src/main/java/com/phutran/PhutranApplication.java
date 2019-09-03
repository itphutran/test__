package com.phutran;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class PhutranApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhutranApplication.class, args);
	}
	
}
