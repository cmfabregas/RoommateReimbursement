package com.example.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Reimbursement;
import com.example.service.ReimbursementService;

@RestController
@RequestMapping(value="/reimbursements")
@CrossOrigin(origins="*")
public class ReimbursementController {

		private ReimbursementService rServ;
		
		public ReimbursementController() {
			// TODO Auto-generated constructor stub
		}
		
		@Autowired
		public ReimbursementController( ReimbursementService rServ) {
			super();
			this.rServ = rServ;
		}
		
		@PostMapping("/submitReimbursement")
		public ResponseEntity<String> insertReimbursement(@RequestBody Reimbursement reimbur, BindingResult result){
			System.out.println(reimbur);
//			if(result.hasErrors()) {
//				System.out.println(result.getFieldError());
//				return new ResponseEntity<>(result.getFieldError().getCode() + " " + result.getFieldError().getDefaultMessage(), HttpStatus.NOT_ACCEPTABLE);
//			}
			rServ.insertReimbursement(reimbur);
			return new ResponseEntity<String>("inserted", HttpStatus.CREATED);
		}
		
}
