package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Reimbursement;

public interface ReimbursementRepository extends JpaRepository<Reimbursement, Integer>{
	
	public List<Reimbursement> finalAll();
	public Reimbursement findByR_Id( Integer reimbursementId);
	public Reimbursement findByGroupName (String name);
	

}
