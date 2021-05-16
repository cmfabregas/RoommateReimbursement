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
    public Group findByGroupId(int groupId);

    public List<Group> findGroupByGroupUsersAndGroupId();
    //public List<Group>

    //@Query("SELECT g FROM rmr_group g JOIN join_user_group jug ON g.group_id = jug.group_id JOIN rmr_user u ON jug.user_id = u.user_id WHERE u.user_id = :userId")
    @Query("select g from Group g JOIN g.groupUsers u where u.userId = :userId ")
    public List<Group> findGroupsByUserId(@Param("userId") int userId);

    @Query("select g from Group g JOIN g.groupUsers u where u.username = :username")
    public List<Group> findGroupsByUsername(@Param("username") String username);







}
