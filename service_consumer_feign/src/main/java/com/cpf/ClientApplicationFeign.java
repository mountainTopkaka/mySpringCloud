package com.cpf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class ClientApplicationFeign {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplicationFeign.class, args);
    }
}
