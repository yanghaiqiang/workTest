package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.zuul.filters.route.RestClientRibbonCommandFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
public class Application {

	/**
	 * Application 注解其实还可以只使用@SpringCloudApplication来注解，因为这个接口
	 * 里加了@EnableCircuitBreaker、@EnableDiscoveryClient、@SpringBootApplication
	 * 所以发现服务、断路器是spring-Cloud应用的标准需要
	 * @return
	 */
	@Bean
	@LoadBalanced
	RestTemplate restTemplate(){
		return  new RestTemplate();
	}
	public static void main(String[] args) {
		//SpringApplication.run(Application.class, args);
		new SpringApplicationBuilder(Application.class).web(true).run(args);
	}
}
