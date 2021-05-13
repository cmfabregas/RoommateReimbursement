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

    public Group()
    {

    }
}
