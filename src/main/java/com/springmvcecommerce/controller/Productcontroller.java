package com.springmvcecommerce.controller;

 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

 
@RestController
public class Productcontroller {

@GetMapping("/hello")
public String getHello() {
	return "hello ";
}
	
}
