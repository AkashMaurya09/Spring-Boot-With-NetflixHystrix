package com.java.server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service1")
public class service1 {
	@GetMapping("/mssg")
	public String service_1() {
		return "This is service one";
	}

}
