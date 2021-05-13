package com.example.model;


import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "reimbursement")
public class Reimbursement {

    @Id
    @Column(name = "reimb_id")
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

    @ManyToMany(fetch= FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name= "mr_group",
            joinColumns = {@JoinColumn(name = "reimb_id")},
            inverseJoinColumns = {@JoinColumn (name="tag_id")})
    private List<Group> groups = new ArrayList<>();


    public Reimbursement() {
    }


}
