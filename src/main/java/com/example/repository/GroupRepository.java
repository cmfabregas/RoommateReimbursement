package com.example.repository;

import com.example.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Integer> {

    public List<Group> findAll();
    public Group findByGroupName(String groupName);
    public Group findByGroupId(int groupId);



}
