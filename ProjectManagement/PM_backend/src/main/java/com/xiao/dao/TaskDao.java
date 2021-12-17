package com.xiao.dao;

import com.xiao.pojo.Task;
import com.xiao.pojo.TeamTask;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TaskDao {
    List<Task> findAllByTeacherId(String teacherId);
    Task findById(String id);
    void add(Task task);
    void update(Task task);
    void deleteById(String id);
    Double findProportion(@Param("studentId") String studentId,@Param("taskId") String taskId);
    TeamTask findTeamTask(@Param("teamId") String teamId,@Param("taskId") String taskId);
}
