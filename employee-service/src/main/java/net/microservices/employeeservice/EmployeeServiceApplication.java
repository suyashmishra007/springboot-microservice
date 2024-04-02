package net.microservices.employeeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class EmployeeServiceApplication {
  @Bean// We just need to create a method,that returns an instance of the class and we need to annotate that method with @Bean configuration
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }
  public static void main(String[] args) {
    SpringApplication.run(EmployeeServiceApplication.class, args);
  }
}