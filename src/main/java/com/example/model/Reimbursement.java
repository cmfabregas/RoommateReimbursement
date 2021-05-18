package com.example.model;


import java.util.*;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "rmr_reimbursement")
@ToString
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reimbursement {

    @Id
    @Column(name = "reimb_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int reimbId;
    @Column(name = "reimb_amount")
    private double reimbAmount;

    @Column(name="reimb_description")
    private String reimbDescription;

    @Column(name="reimb_receipt")
    private String reimbReceipt;

    @Column(name = "reimb_fully_paid")
    private boolean reimbFullyPaid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Group_FK")
    @JsonBackReference
    private Group group;

//    @Column(name = "user_id")
//    private int user_id;
    
    @Column(name = "username")
    private String username;

    @Column(name = "assigne")
    private String assigne;



    public Reimbursement(double reimbAmount, String reimbDescription, String reimbReceipt, boolean reimbFullyPaid, Group groupList, String username) {
        this.reimbAmount = reimbAmount;
        this.reimbDescription = reimbDescription;
        this.reimbReceipt = reimbReceipt;
        this.reimbFullyPaid = reimbFullyPaid;
        this.username = username;
    }
    
    public Reimbursement(double reimbAmount, String reimbDescription, String reimbReceipt, boolean reimbFullyPaid, Group groupList, String username,String assigne) {
        this.reimbAmount = reimbAmount;
        this.reimbDescription = reimbDescription;
        this.reimbReceipt = reimbReceipt;
        this.reimbFullyPaid = reimbFullyPaid;
        this.username = username;
        this.assigne=assigne;
    }
}
