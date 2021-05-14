package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	
	
	public List<User>findByUserId(int id);
	//public List<User>findByRid(int id);

	//public User findByUsernameAndPassword(String username, String password);

	public User findByUsernameAndPassword(String username, String password);
	

}
