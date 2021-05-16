package com.example.controller;


import com.example.model.Group;
import com.example.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/groups")
@CrossOrigin(origins = "*")
public class GroupController {

    private GroupService groupService;

    @InitBinder
    protected void initBinder(WebDataBinder binder){
       // binder.setValidator();
    }


    public GroupController() {
    }

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
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

//    @GetMapping("/{userId}")
//    public ResponseEntity<List<Group>> getGroupsByUserId(@PathVariable("userId") int id){
//          return new ResponseEntity<List<Group>>()
//    }







}
