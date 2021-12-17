package com.xiao.dao;

import com.xiao.pojo.Team;

import java.util.List;

public interface TeamDao {
    Team findById(String id);
    Team findDetailsById(String id);
    void add(Team team);
    void deleteById(String id);
    List<Team> findAllByTeacherId(String teacherId);
    void update(Team team);
}
