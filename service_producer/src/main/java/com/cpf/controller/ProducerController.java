package com.cpf.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/baseProducer")
public class ProducerController {

    @Value("${spring.application.name}")
    private String name;

    @Value("${server.port}")
    private String port;

    @RequestMapping("/hi")
    public String hi(@RequestParam String id){
        return "hi, " + id + ", baseProducer = " + name + ":" + port;
    }
}
