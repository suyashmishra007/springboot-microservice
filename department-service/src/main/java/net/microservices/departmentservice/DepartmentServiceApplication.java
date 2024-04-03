package net.microservices.departmentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DepartmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
	}

}
/*
maven->department-service->lifecycle->package
we get the jar file inside target folder.

now goto the department-service folder,
run in terminal -> java -jar target/department-service-0.0.1-SNAPSHOT.jar --server.port=8082

 */
