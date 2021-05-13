package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Reimbursement;
import com.example.repository.ReimbursementRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor(onConstructor=@__(@Autowired))
@NoArgsConstructor
public class ReimbursementService {
	private ReimbursementRepository rRepo;
	
	public void insertReimbursement(Reimbursement reimbur) {
		rRepo.save(reimbur);
	}
	
	public List<Reimbursement> getAllReimbursement(){
		return rRepo.finalAll();
	}
	
	public Reimbursement getByReimbursementId(int id) {
		return rRepo.findByR_Id(id);
	}
	
//	public Reimbursement getByGroupName()

}
