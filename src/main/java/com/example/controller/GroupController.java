package com.example.controller;


import com.example.model.Group;
import com.example.model.Reimbursement;
import com.example.model.User;
import com.example.service.GroupService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping(value = "/groups")
@CrossOrigin(origins = "*")
public class GroupController {

    private GroupService groupService;
    private UserService userService;

    @InitBinder
    protected void initBinder(WebDataBinder binder){
       // binder.setValidator();
    }


    public GroupController() {
    }

    @Autowired
    public GroupController(GroupService groupService, UserService userService) {
        this.groupService = groupService;
        this.userService = userService;
    }


    @GetMapping()
    public ResponseEntity<List<Group>> getAllGroups(){
        return new ResponseEntity<List<Group>>(groupService.getAllGroups(),HttpStatus.OK);
    }

    @GetMapping("/init")
    public ResponseEntity<String> insertInitialGroup(@RequestBody Group group){
        System.out.println(group);
        groupService.insertGroup(group);
        return new ResponseEntity<String>("Group created", HttpStatus.CREATED);
    }

    @PostMapping()
    public ResponseEntity<String> insertGroup(@RequestBody Group group){
        System.out.println(group);
        groupService.insertGroup(group);
        return new ResponseEntity<String>("Group Created", HttpStatus.CREATED);
    }

    @PostMapping(value = "/addusertogroup")
    public ResponseEntity<String> addUserToGroup(@RequestBody LinkedHashMap<String, String> data){

        String username = data.get("username");
        int groupId = Integer.parseInt(data.get("groupId"));

        Group group = groupService.getGroupById(groupId);
        User addedUser = userService.getuserByUserName(username);

        List<User> uList = group.getGroupUsers();
        uList.add(addedUser);

        group.setGroupUsers(uList);

        groupService.insertGroup(group);
        return new ResponseEntity<>("Successfully added user", HttpStatus.ACCEPTED);

    }

    @GetMapping("/{groupname}")
    public ResponseEntity<Group> getGroupName(@PathVariable("groupname") String name){
        Group group = groupService.getGroupByName(name);

        if(group == null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Group>(group, HttpStatus.OK);
    }

    @GetMapping("/username/{userId}")
    public ResponseEntity<List<Group>> getGroupByUserId(@PathVariable("userId") int userId) {
        return new ResponseEntity<List<Group>>(groupService.getAllGroupsByUserId(userId), HttpStatus.OK);
    }

    @DeleteMapping("/{groupId}")
    public ResponseEntity<String> deleteGroupById(@PathVariable("groupId") int groupId){
        Group group = groupService.getGroupById(groupId);
        groupService.deleteGroup(group);
        return new ResponseEntity<>("Group successfully deleted", HttpStatus.GONE);
    }
    
    @GetMapping("/reimbursement/{groupId}")
    public ResponseEntity<List<Reimbursement>> getReimbursementListByGroup(@PathVariable int groupId){
    	Group group = groupService.getGroupById(groupId);
    	List<Reimbursement> reimbursementList = group.getReimbursements();
    	return new ResponseEntity<List<Reimbursement>>(reimbursementList,HttpStatus.OK);
    }

//    @GetMapping("/{userId}")
//    public ResponseEntity<List<Group>> getGroupsByUserId(@PathVariable("userId") int id){
//          return new ResponseEntity<List<Group>>()
//    }







}
