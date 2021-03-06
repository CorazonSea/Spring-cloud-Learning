package com.example.eurekaconsumerhystrix.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "eureka-client-feign")
public interface EurekaClientFeign{
	
	@GetMapping("/dc")
	String dc();

}
