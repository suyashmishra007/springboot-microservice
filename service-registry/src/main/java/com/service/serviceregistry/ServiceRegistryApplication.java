package com.service.serviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRegistryApplication.class, args);
	}

}
/*
Create Spring boot project as microservice.
Add @EnableEurekaServer annotation
Disable Eureka Server as Eureka Client.
Launch Eureka Server(Demo)
Registering Department-Service Microservice as Eureka Client
Run Department-Service Eureka Client(Demo)
Registering Employee-Service Microservice as Eureka Client
Run Employee-Service Eureka Client(Demo)
Multiple Instance of Department Service
 */