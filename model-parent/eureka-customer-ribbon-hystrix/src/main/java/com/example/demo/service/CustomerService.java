package com.example.demo.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by yanghaiqiang on 2017/8/20.
 */
@Service
public class CustomerService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallbackHello")
    public String helloService(){
        return restTemplate.getForEntity("http://EUREKA-CLIENT/hello",String.class)
                .getBody();
    }

    public String fallbackHello(){
        return  "yhq-error";
    }
}
