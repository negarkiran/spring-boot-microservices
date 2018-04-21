package com.kiran;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.kiran.client.EmployeeConsumerClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EmployeeConsumer {
	public static void main(String args[]){
		ApplicationContext context= SpringApplication.run(EmployeeConsumer.class, args);
		
		EmployeeConsumerClient employeeConsumerClient = context.getBean(EmployeeConsumerClient.class);
		System.out.println(employeeConsumerClient);
		employeeConsumerClient.getEmployee();
	}
	
	@Bean
	public EmployeeConsumerClient employeeConsumerClient(){
		return new EmployeeConsumerClient();
	}
}
