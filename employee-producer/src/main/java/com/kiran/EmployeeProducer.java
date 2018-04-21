package com.kiran;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EmployeeProducer {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeProducer.class, args);
	}
}
