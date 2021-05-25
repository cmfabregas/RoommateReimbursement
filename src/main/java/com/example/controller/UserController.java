package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.service.EmailService;
//import com.example.service.UserService;


@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	private EmailService eservice;
	
	@PostMapping
	public User createUser(@RequestBody User user) {
		eservice.createUser(user);
		
		
		return user;
		
	}
	
	@PostMapping("/forgotPassword")
	public ResponseEntity<User> forgotPassword(@RequestBody User user) {
		User newUser = eservice.forgotPassword(user);
		if(newUser==null) {
	     return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
        return new ResponseEntity<User>(newUser, HttpStatus.OK);

		
	}

	@PutMapping("/generateNewPassword")
	public User generateNewPassword(@RequestBody User user ) {
		eservice.generateNewPassword(user);
		
		return user;
		
	}

}
