package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.User;
import com.example.repository.UserRepo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {

	private UserRepo urepo;

	
public void insert(User user) {
		
		System.out.println(user);
		urepo.save(user);
	}


public User getuserlogin(String username,String password) {
	
	return urepo.findByUsernameAndPassword(username, password);
}


public User getuserByUserName(String name) {
	
	return urepo.findByUsername(name);
	
}



	
}
