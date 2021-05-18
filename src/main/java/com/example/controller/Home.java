package com.example.controller;

import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Group;
import com.example.model.Reimbursement;
//import com.example.model.Food;
import com.example.model.User;
import com.example.repository.GroupRepository;
import com.example.service.GroupService;
import com.example.service.ReimbursementService;
import com.example.service.UserService;
import com.example.controller.Login;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping(value="/home")
@CrossOrigin(origins = "*")
@NoArgsConstructor

public class Home {
	
	
	private UserService Userv;
	private GroupService Gserv;
	private ReimbursementService Rserv;

	public Login hm;
	
	
	@Autowired
	public Home(UserService Userv, GroupService Gserv, ReimbursementService Rserv) {
		
		super();
		this.Userv=Userv;
		this.Gserv = Gserv;
		this.Rserv = Rserv;
	}
	
	@PostMapping("/rem")
	public ResponseEntity<Object> insertrem(@RequestBody LinkedHashMap<String,String> reimbursement){
		
	//	User user1 = new User(user.get("GroupName"), user.get("ReimbursementName"), Integer.parseInt(user.get("ReimbursementAmount")));
		String groupName = reimbursement.get("GroupName");
		System.out.println(reimbursement);
		Group group = Gserv.getGroupByName(groupName);
		String reimbursementName = reimbursement.get("ReimbursementName");
		Double reimbursementAmount = Double.valueOf(reimbursement.get("ReimbursementAmount"));
		String reimbursementUserName = reimbursement.get("username");
		String assigne = reimbursement.get("assign");
		Boolean isPaid = false;
		System.out.println("Creating reimbursement. From Group : " + groupName);
		Reimbursement rbur = new Reimbursement(reimbursementAmount, reimbursementName, "", isPaid, group, reimbursementUserName,assigne);
		System.out.println(rbur);
		int rID = Rserv.insertReimbursement(rbur);

		//Userv.insertFood(user1);
		return new ResponseEntity<Object>(Rserv.getByReimbursementId(rID), HttpStatus.CREATED);

		//return new ResponseEntity<String> ("Food Created",HttpStatus.CREATED);
		
		
	}
	
	//Table data is need to complete the get request otherwise it will return error (null)
	
	@PostMapping("/dash")
	public ResponseEntity<Object> get(@RequestBody LinkedHashMap<String,String> user){
		//System.out.println("rem");
	//	User user1 = new User(user.get("GroupName"), user.get("ReimbursementName"), Integer.parseInt(user.get("ReimbursementAmount")));
		//System.out.println(user1);
		//HttpSession session=request.getSession(false);
		//String myName=(String)session.getAttribute("uname");

        System.out.println(Userv.getuserByUserName("sam").getUserId());
        System.out.println(Userv.getuserByUserName("sam").getUsername());
        
         Gserv.getGroupById(1);
        
         //return new ResponseEntity<Object>(Gserv.getGroupById(1),HttpStatus.OK);
		//Userv.insertFood(user1);
	//	return new ResponseEntity<Object>(Userv.getFoodByName(user.getGroupName()), HttpStatus.CREATED);

		return null;
		//return new ResponseEntity<String> ("Food Created",HttpStatus.CREATED);
		
		
	}

}
