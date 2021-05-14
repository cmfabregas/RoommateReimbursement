package com.example.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.service.UserService;

import lombok.NoArgsConstructor;

@RestController
@RequestMapping(value="/login")
@CrossOrigin(origins = "*")
@NoArgsConstructor

public class Login {
	
	private UserService fserv;
	//private UserService Userv;

	
	@Autowired
	public Login(UserService fserv) {
		
		super();
		this.fserv=fserv;
	}
	
	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody User user,HttpSession session){
		//System.out.println(fserv.getuserlogin(food.getFirstname(), food.getPassword()));
		System.out.println(user);

		System.out.println("register");

		//fserv.insertFood(food);
		
	
       // String n=(String)session.getAttribute("uname");  

		User log=fserv.getuserlogin(user.getUsername(), user.getPassword());
		System.out.println(log);
		if(log==null) {
			System.out.println("asi");
			
			//return new ResponseEntity<Object>(log,HttpStatus.CREATED);
	        //httpResponse.sendRedirect("/home");

		    //return "redirect:/home";
		    //return "redirect:/home";
			return null;

		}
		
		//session.invalidate();
        session.setAttribute("uname",user.getUsername());  
        session.setAttribute("uid",user.getUserId());  
        System.out.println(session.getAttribute("uname"));
       // System.out.println(session.getAttribute("uname"));  
		return new ResponseEntity<Object>(fserv.getuserlogin(user.getUsername(), user.getPassword()), HttpStatus.CREATED);
		//return null;


		//return new ResponseEntity<String> ("Food Created",HttpStatus.CREATED);
		
		
	}
	
	@PostMapping("/register")
	public ResponseEntity<Object> insert(@RequestBody User user,BindingResult result){
		System.out.println(user);
		
		fserv.insert(user);
		//return new ResponseEntity<Object>(fserv.getFoodByName(food.getFirstname()), HttpStatus.CREATED);
		
		return null;
		//return new ResponseEntity<String> ("Food Created",HttpStatus.CREATED);
		
		
	}
	

	

}
