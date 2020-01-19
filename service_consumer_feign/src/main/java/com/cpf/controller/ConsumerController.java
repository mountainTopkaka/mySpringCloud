package com.cpf.controller;

import com.cpf.serviceFeign.ServiceAFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    ServiceAFeignClient serviceAFeignClient;

    @RequestMapping("/hi")
    public String hi(@RequestParam String id){
        return "ConsumerController Feign --> " + serviceAFeignClient.hi(id);
    }

}
