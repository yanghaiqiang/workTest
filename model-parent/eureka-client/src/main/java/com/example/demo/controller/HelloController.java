package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yanghaiqiang on 2017/8/19.
 */
@RestController
public class HelloController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String index(){

        ServiceInstance serviceInstance = discoveryClient.getLocalServiceInstance();
        System.out.print("/hello,host:_" + serviceInstance.getHost() + ", service_id" +
                serviceInstance.getServiceId());
        return "Hello World";
    }
}
