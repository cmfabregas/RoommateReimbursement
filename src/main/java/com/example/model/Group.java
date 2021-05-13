package com.example.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="group")
public class Group {

    @Id
    @Column(name="group_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int groupId;

    @Column(name = "group_name")
    private String groupName;

    @Column(name="group_description")
    private String groupDescription;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "groups")
    private Set<User> groupUsers;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "Reimb_FK", referencedColumnName = "group_id")
    private Reimbursement reimbHolder;

    public Group()
    {

    }

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

    public Set<User> getGroupUsers() {
        return groupUsers;
    }

    public void setGroupUsers(Set<User> groupUsers) {
        this.groupUsers = groupUsers;
    }

    public Reimbursement getReimbHolder() {
        return reimbHolder;
    }

    public void setReimbHolder(Reimbursement reimbHolder) {
        this.reimbHolder = reimbHolder;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                ", groupDescription='" + groupDescription + '\'' +
                ", groupUsers=" + groupUsers +
                ", reimbHolder=" + reimbHolder +
                '}';
    }
}
