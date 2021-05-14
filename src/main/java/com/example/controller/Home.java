package com.example.controller;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.service.UserService;

import lombok.NoArgsConstructor;

@RestController
@RequestMapping(value="/home")
@CrossOrigin(origins = "*")
@NoArgsConstructor

public class Home {
	
	
	private UserService Userv;
	
	@Autowired
	public Home(UserService Userv) {
		
		super();
		this.Userv=Userv;
	}
	
	@PostMapping("/rem")
	public ResponseEntity<Object> insert(@RequestBody LinkedHashMap<String,String> user){
		System.out.println("rem");
	//	User user1 = new User(user.get("GroupName"), user.get("ReimbursementName"), Integer.parseInt(user.get("ReimbursementAmount")));
		//System.out.println(user1);

		//Userv.insertFood(user1);
	//	return new ResponseEntity<Object>(Userv.getFoodByName(user.getGroupName()), HttpStatus.CREATED);

		return null;
		//return new ResponseEntity<String> ("Food Created",HttpStatus.CREATED);
		
		
	}
	

}
