package com.xiao.service;

import com.xiao.pojo.Team;

import java.util.List;

public interface TeamService {
    void addToTeam(String id,String studentId);
    void goAwayTeam(String studentId);
    Team findDetailsById(String id);
    Team findById(String id);
    void setTopic(String topicId,String teamId);
}
