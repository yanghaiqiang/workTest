package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by yanghaiqiang on 2017/8/19.
 */
@RestController
public class CustomerController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/ribbon-customer",method = RequestMethod.GET)
    public String index(){
        System.out.print("*********************yqh***********");
        return restTemplate.getForEntity("http://EUREKA-CLIENT/hello",String.class).getBody();
    }
}
