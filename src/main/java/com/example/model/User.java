package com.example.model;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="rmr_user")
@ToString
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    @Column(name="username")
    private String username;

    @Column(name = "useremail")
    private String email;

    @Column(name = "u_password")
    private String password;

    @Column(name="first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
    
	@Column(name = "specialcode")
	private String specialcode;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "JOIN_USER_GROUP",
        joinColumns = {@JoinColumn(name = "userId")},
        inverseJoinColumns = {@JoinColumn(name = "groupId")})
    private List<Group> groups = new ArrayList<>();



 
    public User(int userId, String username, String email, String password, String firstName, String lastName) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(String username, String email, String password, String firstName, String lastName) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public User(String username, String email, String password, String firstName) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        //this.lastName = lastName;
    }
    
    

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
    
	public String getSpecialcode() {
		return specialcode;
	}

	public void setSpecialcode(String specialcode) {
		this.specialcode = specialcode;
	}


}
