package com.example.service;

import com.example.model.Group;
import com.example.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {



    private GroupRepository groupRepo;

    public GroupService() {
    }

    @Autowired
    public GroupService(GroupRepository groupRepo) {
        this.groupRepo = groupRepo;
    }

    public Group getGroupByName(String groupName){
        return groupRepo.findByGroupName(groupName);
    }

    public void insertGroup(Group group){
        groupRepo.save(group);
    }

    public List<Group> getAllGroupsByUserId(int userId) {
        return groupRepo.findGroupsByUserId(userId);
    }

    public List<Group> getAllGroupsByUsername(String username){
        return groupRepo.findGroupsByUsername(username);
    }


    public List<Group> getAllGroups(){
        return groupRepo.findAll();
    }

    public void deleteGroup(Group group){
        groupRepo.delete(group);
    }

    public Group getGroupById(int id){
        return groupRepo.findGroupByGroupId(id);
    }


}
