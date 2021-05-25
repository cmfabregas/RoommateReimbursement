package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.model.Group;
import com.example.model.Reimbursement;

public interface ReimbursementRepository extends JpaRepository<Reimbursement, Integer>{
	
	public List<Reimbursement> findAll();
	public Reimbursement findByReimbId( Integer reimbursementId);
	public Reimbursement findByGroup (Group group);
	
	@Query("select r from Reimbursement r JOIN r.group g where g.groupId = :groupId ")
	public List<Reimbursement> findAllFromGroup (int groupId);
	

}
