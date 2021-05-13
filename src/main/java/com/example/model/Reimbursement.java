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

    @OneToMany(mappedBy = "reimbHolder", fetch = FetchType.LAZY)
    private List<Group> groupList = new ArrayList<>();

    @Column(name = "user_id")
    private int user_id;


    public Reimbursement() {
    }


    public Reimbursement(double reimbAmount, Date reimbSubmitted, Date reimbResolved, String reimbDescription, String reimbReceipt, boolean reimbFullyPaid, List<Group> groupList, int user_id) {
        this.reimbAmount = reimbAmount;
        this.reimbSubmitted = reimbSubmitted;
        this.reimbResolved = reimbResolved;
        this.reimbDescription = reimbDescription;
        this.reimbReceipt = reimbReceipt;
        this.reimbFullyPaid = reimbFullyPaid;
        this.groupList = groupList;
        this.user_id = user_id;
    }

    public double getReimbAmount() {
        return reimbAmount;
    }

    public void setReimbAmount(double reimbAmount) {
        this.reimbAmount = reimbAmount;
    }

    public Date getReimbSubmitted() {
        return reimbSubmitted;
    }

    public void setReimbSubmitted(Date reimbSubmitted) {
        this.reimbSubmitted = reimbSubmitted;
    }

    public Date getReimbResolved() {
        return reimbResolved;
    }

    public void setReimbResolved(Date reimbResolved) {
        this.reimbResolved = reimbResolved;
    }

    public String getReimbDescription() {
        return reimbDescription;
    }

    public void setReimbDescription(String reimbDescription) {
        this.reimbDescription = reimbDescription;
    }

    public String getReimbReceipt() {
        return reimbReceipt;
    }

    public void setReimbReceipt(String reimbReceipt) {
        this.reimbReceipt = reimbReceipt;
    }

    public boolean isReimbFullyPaid() {
        return reimbFullyPaid;
    }

    public void setReimbFullyPaid(boolean reimbFullyPaid) {
        this.reimbFullyPaid = reimbFullyPaid;
    }

    public List<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Group> groupList) {
        this.groupList = groupList;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getReimbId() {
        return reimbId;
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "reimbId=" + reimbId +
                ", reimbAmount=" + reimbAmount +
                ", reimbSubmitted=" + reimbSubmitted +
                ", reimbResolved=" + reimbResolved +
                ", reimbDescription='" + reimbDescription + '\'' +
                ", reimbReceipt='" + reimbReceipt + '\'' +
                ", reimbFullyPaid=" + reimbFullyPaid +
                ", groupList=" + groupList +
                ", user_id=" + user_id +
                '}';
    }
}
