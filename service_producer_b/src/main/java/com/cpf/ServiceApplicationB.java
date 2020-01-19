package com.cpf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServiceApplicationB {

    public static void main(String[] args) {
        SpringApplication.run(ServiceApplicationB.class,args);
    }
}
