package com.mragowo.springboot.nplusselect.controller;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthorController  {

	@GetMapping("/hello")
	public ResponseEntity<String> getResponse() {
		return ResponseEntity.ok("Hello"); 
	}
}
