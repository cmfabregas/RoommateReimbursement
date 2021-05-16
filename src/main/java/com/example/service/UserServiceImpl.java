package com.example.service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.example.model.User;
//import com.example.entity.UserEntity;
import com.example.repository.UserRepository;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Service
public class UserServiceImpl { //implements UserService {
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private JavaMailSender jMailSender;
	

	//@Override
	public User createUser(User user) {
		//UserEntity entity = new UserEntity();
		//entity.setEmail(user.getEmail());
		repository.save(user);
		
		
		// TODO Auto-generated method stub
		return user;
	}

	//@Override
	public User forgotPassword(User user) {
	User ent = repository.findByEmail(user.getEmail());
			if(ent!=null) {
		
		sendEmail(user, ent);
		return user;
			}
		// TODO Auto-generated method stub
		return null;
	}
	
	
	private void sendEmail(User user, User ent) {
	     SimpleMailMessage msg = new SimpleMailMessage();
	        msg.setTo("waglepuja@gmail.com");

	        msg.setSubject("Reset your password");
	        String link="";
	        UUID uuid = UUID.randomUUID();
			try {
				link = generateLink(uuid);
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      
	        msg.setText("Hello World \n Spring Boot Email"
	        		
	        		+ "    "
	        		+link);

	        jMailSender.send(msg);
	        
	        saveSpecialCode(ent, uuid);
	}
	//https//www.ourdomain.com/myRoomate/resetpassword/?id=speicalcodehere
	private String generateLink(UUID uuid) throws UnknownHostException {
		//Random uuid = new Random();
		//UUID uuid = UUID.randomUUID();
		
		String hostName =  InetAddress.getLocalHost().getHostName();
		StringBuilder sb = new StringBuilder();
		sb.append("http://");
		sb.append("localhost:4200");
		sb.append("/resetpassword/?id=");
		sb.append(uuid.toString());
		return sb.toString();
		
		
	}
	
	
	
	private void saveSpecialCode(User user, UUID uuid) {
		user.setSpecialcode(uuid.toString());
		
		
		repository.save(user);
		
	}

	//@Override
	public User generateNewPassword(User user) {
		User ent = repository.findBySpecialcode(user.getSpecialcode());
		if(ent!=null) {
		ent.setPassword(user.getPassword());
		
		repository.save(ent);
		
		return user;
	}
		// TODO Auto-generated method stub
		return null;
	}

}
