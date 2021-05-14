package com.example.repository;

import com.example.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Integer> {

    public List<Group> findAll();
    public Group findByGroupName(String groupName);
    public Group findByGroupId(int groupId);

    //public List<Group>

    //@Query("SELECT g FROM rmr_group g JOIN join_user_group jug ON g.group_id = jug.group_id JOIN rmr_user u ON jug.user_id = u.user_id WHERE u.user_id = :userId")
    @Query("select g from Group g JOIN fetch g.groupUsers")
    public List<Group> findGroupByUserId(@Param("userId") int userId);





}
