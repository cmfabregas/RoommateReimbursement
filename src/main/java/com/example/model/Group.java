package com.example.model;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="rmr_group")
@ToString
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Group {

    @Id
    @Column(name="group_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int groupId;

    @Column(name = "group_name")
    private String groupName;

    @Column(name="group_description")
    private String groupDescription;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "JOIN_USER_GROUP",
            joinColumns = {@JoinColumn(name = "groupId")},
            inverseJoinColumns = {@JoinColumn(name = "userId")})
    private List<User> groupUsers;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "group")
    private List<Reimbursement> reimbursements = new ArrayList<>();



 

    public int getGroupId() {
        return groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupDescription() {
        return groupDescription;
    }

    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
    }

    public List<User> getGroupUsers() {
        return groupUsers;
    }

    public void setGroupUsers(List<User> groupUsers) {
        this.groupUsers = groupUsers;
    }

    public List<Reimbursement> getReimbursements() {
        return reimbursements;
    }

    public void setReimbursements(List<Reimbursement> reimbursements) {
        this.reimbursements = reimbursements;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                ", groupDescription='" + groupDescription + '\'' +
                ", groupUsers=" + groupUsers +
                '}';
    }
}
