package com.example.controller;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Group;
import com.example.model.Reimbursement;
import com.example.service.GroupService;
import com.example.service.ReimbursementService;

@RestController
@RequestMapping(value="/reimbursements")
@CrossOrigin(origins="*")
public class ReimbursementController {

		private ReimbursementService rServ;
		private GroupService gServ;
		
		public ReimbursementController() {
			// TODO Auto-generated constructor stub
		}
		
		@Autowired
		public ReimbursementController( ReimbursementService rServ, GroupService gServ) {
			super();
			this.rServ = rServ;
			this.gServ = gServ;
		}
		
		@PostMapping("/submitReimbursement")
		public ResponseEntity<String> insertReimbursement(@RequestBody Reimbursement reimbur, BindingResult result){
			System.out.println("Entered submit reimbursement");
			System.out.println(reimbur);
//			if(result.hasErrors()) {
//				System.out.println(result.getFieldError());
//				return new ResponseEntity<>(result.getFieldError().getCode() + " " + result.getFieldError().getDefaultMessage(), HttpStatus.NOT_ACCEPTABLE);
//			}
			rServ.insertReimbursement(reimbur);
			return new ResponseEntity<String>("inserted", HttpStatus.CREATED);
		}
		
		@GetMapping("/getGroupReimbursements/{groupId}")
		public ResponseEntity<List<Reimbursement>> getReimbursementByGroup(@PathVariable("groupId") int groupId){
			return new ResponseEntity<List<Reimbursement>>( rServ.getAllByGroup(groupId), HttpStatus.OK);
			
		}
		
		@PutMapping("/addGroup")
		public ResponseEntity<String> addGroup(@RequestBody LinkedHashMap<String,String> body){
			int groupId = Integer.parseInt(body.get("groupId"));
			int reburId = Integer.parseInt(body.get("reimbursementId"));
			Group group = gServ.getGroupById(groupId);
			Reimbursement rebur = rServ.getByReimbursementId(reburId);
			rebur.setGroup(group);
			rServ.updateReimbursement(rebur);
			return new ResponseEntity<>("updated", HttpStatus.OK);
			
		}
}
