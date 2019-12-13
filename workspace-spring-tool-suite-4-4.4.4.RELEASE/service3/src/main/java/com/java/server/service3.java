package com.java.server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service3")
public class service3 {
	@GetMapping("/mssg")
	public String service_3() {
		return "this is service 3";
	}

}
