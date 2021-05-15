package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.service.UserServiceImpl;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")//, allowedHeaders = "*")
public class UserController {
	
	@Autowired
	private UserServiceImpl uservice;
	
	@PostMapping
	public User createUser(@RequestBody User user) {
		uservice.createUser(user);
		
		
		return user;
		
	}
	
	@PostMapping("/forgotPassword")
	public User forgotPassword(@RequestBody User user) {
		uservice.forgotPassword(user);
		
		return user;
		
	}

	@PutMapping("/generateNewPassword")
	public User generateNewPassword(@RequestBody User user ) {
		uservice.generateNewPassword(user);
		
		return user;
		
	}

}
