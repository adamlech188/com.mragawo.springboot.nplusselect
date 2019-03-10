package com.mragowo.springboot.nplusselect.controller;

import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mragowo.springboot.nplusselect.hateos.PersonResource;

@RestController
@RequestMapping("/api")
public class PersonController {

	@GetMapping("/person")
	public ResponseEntity<PersonResource> getPerson() {
		PersonResource personResource = new PersonResource(); 
		
		personResource.setFirstName("Nga");
		personResource.setLastName("Huynh");
		
		Link link = new Link("http://localhost:8080/api/person");
		personResource.add(link);
		return ResponseEntity.ok(personResource); 
	}
}
