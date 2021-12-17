package com.xiao.dao;

import com.xiao.pojo.TeamTask;

public interface TeamTaskDao {
    TeamTask findByTIdAndTId(TeamTask teamTask);
    void add(TeamTask teamTask);
    void delete(TeamTask teamTask);
    void update(TeamTask teamTask);
    void deleteByTeamId(String teamId);
    void deleteBuTaskId(String taskId);
}
