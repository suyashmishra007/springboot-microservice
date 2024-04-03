package net.microservices.employeeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class EmployeeServiceApplication {
//  @Bean// We just need to create a method,that returns an instance of the class and we need to annotate that method with @Bean configuration
//  public RestTemplate restTemplate() {
//    return new RestTemplate();
//  }
//  @Bean
//  public WebClient webClient(){
//    return WebClient.builder().build();
//  }
  public static void main(String[] args) {
    SpringApplication.run(EmployeeServiceApplication.class, args);
  }
}