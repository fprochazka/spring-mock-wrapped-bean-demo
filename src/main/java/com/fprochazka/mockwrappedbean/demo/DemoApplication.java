package com.fprochazka.mockwrappedbean.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.fprochazka")
public class DemoApplication
{

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
