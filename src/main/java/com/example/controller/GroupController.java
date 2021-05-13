package com.example.controller;


import com.example.model.Group;
import com.example.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.ArrayList;
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

    @GetMapping("/initial")
    public ResponseEntity<String> insertGroup(@RequestBody Group group){
        System.out.println(group);
        groupService.insertGroup(group);
        return new ResponseEntity<String>("Group created", HttpStatus.CREATED);
    }




}
