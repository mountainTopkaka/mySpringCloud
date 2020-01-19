package com.cpf.serviceFeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "service-producer") // 这里的name对应调用服务的spring.applicatoin.name
public interface ServiceAFeignClient {

    @RequestMapping(value = "/baseProducer/hi")
    String hi(@RequestParam("id") String id);


}
