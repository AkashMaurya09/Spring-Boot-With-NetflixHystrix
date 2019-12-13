package com.java.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@SpringBootApplication
@EnableHystrix
@RestController
public class HystrixappApplication {
   public static void main(String[] args) {
      SpringApplication.run(HystrixappApplication.class, args);
   }
   @RequestMapping(value = "/")
   @HystrixCommand(fallbackMethod = "fallback_hello", commandProperties = {
		   @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "500")
   })
   public String hello() throws InterruptedException {
      Thread.sleep(600);
      return "Welcome Hystrix";
   }
   private String fallback_hello(Throwable HystrixCommand){
      return "Request fails. It takes long time to response";
   }
}
