package com.security.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloContrller {
	
	@GetMapping("/hello")
	public String sayHello() {
		  
		return "Spring Security Roks!!";
	}
	
	@GetMapping("/bye")
	public String sayBye() {
		  
		return "Get Lost!!";
	}
	

}
