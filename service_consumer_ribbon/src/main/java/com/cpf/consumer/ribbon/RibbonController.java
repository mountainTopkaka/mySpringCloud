package com.cpf.consumer.ribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RibbonController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/hi")
    @HystrixCommand(fallbackMethod = "hiFallback")
    public String hi(@RequestParam String id) {
        return "RibbonController -->" + restTemplate.getForObject("http://service-producer/baseProducer/hi?id=" + id, String.class);
    }

    // 断路器回调方法
    public String hiFallback(String id) {
        return "hi, " + id + ", error!";
    }

}
