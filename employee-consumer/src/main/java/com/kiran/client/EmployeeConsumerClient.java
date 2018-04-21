package com.kiran.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class EmployeeConsumerClient {
	
	@Autowired
	private DiscoveryClient discoveryClient;

	public void getEmployee(){
		
		List<ServiceInstance> serviceInstances = discoveryClient.getInstances("employee-producer");
		String baseURL = serviceInstances.get(0).getUri().toString();
		
		baseURL = baseURL + "/employee";
		
		//String baseURL = "http://localhost:8080/employee";
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<String> response;
		response = restTemplate.exchange(baseURL, HttpMethod.GET, getHeaders(), String.class);
		System.out.println(response.getBody());
		
	}

	private HttpEntity getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}
}
