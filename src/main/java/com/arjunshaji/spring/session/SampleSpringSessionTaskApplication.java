package com.arjunshaji.spring.session;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AutoConfigureBefore
public class SampleSpringSessionTaskApplication {
	public static void main(String[] args) {
		SpringApplication.run(SampleSpringSessionTaskApplication.class, args);
	}
}
