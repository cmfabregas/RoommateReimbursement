package com.example.model;


import java.util.*;
import javax.persistence.*;

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
    @Column(name = "rid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int reimbId;
    @Column(name = "reimb_amount")
    private double reimbAmount;

    @Column(name = "reimb_submitted")
    private Date reimbSubmitted;

    @Column(name="reimb_resolved")
    private Date reimbResolved;

    @Column(name="reimb_description")
    private String reimbDescription;

    @Column(name="reimb_receipt")
    private String reimbReceipt;

    @Column(name = "reimb_fully_paid")
    private boolean reimbFullyPaid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Group_FK")
    private Group group;

    @Column(name = "user_id")
    private int user_id;




    public Reimbursement(double reimbAmount, Date reimbSubmitted, Date reimbResolved, String reimbDescription, String reimbReceipt, boolean reimbFullyPaid, List<Group> groupList, int user_id) {
        this.reimbAmount = reimbAmount;
        this.reimbSubmitted = reimbSubmitted;
        this.reimbResolved = reimbResolved;
        this.reimbDescription = reimbDescription;
        this.reimbReceipt = reimbReceipt;
        this.reimbFullyPaid = reimbFullyPaid;
        this.user_id = user_id;
    }

  
}
