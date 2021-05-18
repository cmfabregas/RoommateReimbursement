package com.example.repository;

import com.example.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;


public interface GroupRepository extends JpaRepository<Group, Integer> {

    public List<Group> findAll();
    public Group findByGroupName(String groupName);
//    public Group findByGroupId(int groupId);

    public Group findGroupByGroupId(int groupId);


    @Query("select g from Group g JOIN g.groupUsers u where u.userId = :userId ")
    public List<Group> findGroupsByUserId(@Param("userId") int userId);

    @Query("select g from Group g JOIN g.groupUsers u where u.username = :username")
    public List<Group> findGroupsByUsername(@Param("username") String username);









}
