package com.example.roommatereimbursement;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.model.Group;
import com.example.model.User;
import com.example.service.EmailService;
import com.example.service.GroupService;

@SpringBootTest
public class GroupServiceTest {
	
	@Autowired
	private GroupService gserv;
	
		
	
	@Test
	@Order(1)
	public void getGroupByNameTest() {
		System.out.println("Testing getgroup by name");
		
		String input = "addingGMtest";
		assertEquals("addingGMtest", gserv.getGroupByName(input).getGroupName());		
	}
	
	@Test
	@Order(2)
	public void getAllGroupsByUsernameTest() {
		System.out.println("Testing getall groups by username");
		
		String input = "manil";
		assertEquals("Hello88", gserv.getAllGroupsByUsername(input).get(0).getGroupName());		
	}
	
	
}
