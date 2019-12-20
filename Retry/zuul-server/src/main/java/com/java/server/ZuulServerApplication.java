package com.java.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.retry.annotation.EnableRetry;

import com.java.filter.ErrorFilter;
import com.java.filter.PostFilter;
import com.java.filter.PreFilter;
import com.java.filter.RouteFilter;

@SpringBootApplication
@EnableZuulProxy
@EnableRetry
@EnableDiscoveryClient
public class ZuulServerApplication {
	
	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}
	
	@Bean 
	public PostFilter postfilter() {
		return new PostFilter();
	}
	
	@Bean
	public PreFilter preFilter() {
		return new PreFilter();
	}
	
	@Bean 
	public RouteFilter routeFilter() {
		return new RouteFilter();
	}
	

	public static void main(String[] args) {
		SpringApplication.run(ZuulServerApplication.class, args);
	}

}
