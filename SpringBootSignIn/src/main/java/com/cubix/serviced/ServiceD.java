package com.cubix.serviced;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan
@SpringBootApplication
public class ServiceD {

	public static void main(String[] args) {
		SpringApplication.run(ServiceD.class, args);
	}

}
