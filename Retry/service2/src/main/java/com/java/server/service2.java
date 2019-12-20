package com.java.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
@RequestMapping("/e")
public class service2 {
	
	Logger logger = LoggerFactory.getLogger(service2.class);
	
	@HystrixCommand(fallbackMethod = "fallback_hello", commandProperties = {
			   @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "900")
	   })
	@GetMapping("/")
	public String service_2() throws InterruptedException {
//		Thread.sleep(1000);
		logger.trace("Successfully chalu ho gaya");
		return "This is service 2";
	}
	public String fallback_hello(Throwable HystrixCommand) throws InterruptedException {
//		Thread.sleep(7000);
		logger.trace("lassadasdpoln");
	      return "Request fails. It takes long time to response";
	   }

}
