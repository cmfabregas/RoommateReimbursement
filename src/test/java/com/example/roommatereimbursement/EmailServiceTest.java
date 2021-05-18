package com.example.roommatereimbursement;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.model.User;
import com.example.service.EmailService;

@SpringBootTest
public class EmailServiceTest {
	
	@Autowired
	private EmailService eserv;
	
	@Autowired
	private EmailService eserv1;
	
	
	@Test
	@Order(1)
	public void forgotPasswordTest() {
		System.out.println("Testing forgot password");
		User user = new User(29, "carlosfabregas", "carlosfabregas@gmail.com", "Password", "Carlos", "Fabregas");
		assertEquals(user, eserv.forgotPassword(user));
		
		User user1 = new User(12, "puja", "waglepuja12@gmail.com", "pass123", "Hello", "Hi");
		System.out.println(eserv.forgotPassword(user1));
		assertEquals(null, eserv.forgotPassword(user1));
	}
	
	/*
	@Test
	@Order(2)
	public void generateNewPasswordTest() {
		System.out.println("Testing generate new password");
		User user2 = new User(29, "carlosfabregas", "carlosfabregas@gmail.com", "Password", "Carlos", "Fabregas");
		assertEquals(user2, eserv1.generateNewPassword(user2));
		
	}
	*/
}
