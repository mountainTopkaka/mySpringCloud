package com.cpf.controller;

import com.cpf.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producerA")
public class ServiceAController {
    @Value("${spring.application.name}")
    private String name;

    @Value("${server.port}")
    private String port;

    @Autowired
    ProducerService producerService;

    @RequestMapping("/hi")
    public String hi(@RequestParam String id){
        return "hi, " + id + ",  ServiceAController = " + name + ":" + port;
    }

    @RequestMapping("/hiService")
    public String hiService(@RequestParam String id){
        return producerService.hi(id);
    }
}
