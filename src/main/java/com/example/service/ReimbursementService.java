package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Group;
import com.example.model.Reimbursement;
import com.example.repository.ReimbursementRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor(onConstructor=@__(@Autowired))
@NoArgsConstructor
public class ReimbursementService {
	private ReimbursementRepository rRepo;
	
	public int insertReimbursement(Reimbursement reimbur) {
		Reimbursement rebur = rRepo.save(reimbur);
		return rebur.getReimbId();
	}
	
	public List<Reimbursement> getAllReimbursement(){
		return rRepo.findAll();
	}
	
	public Reimbursement getByReimbursementId(int id) {
		return rRepo.findByReimbId(id);
	}
	
	public Reimbursement getByGroup( Group group) {
		return rRepo.findByGroup(group);
	}

}
