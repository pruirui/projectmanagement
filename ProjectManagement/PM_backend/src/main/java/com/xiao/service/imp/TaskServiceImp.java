package com.xiao.service.imp;

import com.xiao.dao.TaskDao;
import com.xiao.dao.TeamDao;
import com.xiao.pojo.Student;
import com.xiao.pojo.Task;
import com.xiao.pojo.Team;
import com.xiao.pojo.TeamTask;
import com.xiao.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class TaskServiceImp implements TaskService {

    @Autowired
    private TaskDao taskDao;

    @Autowired
    private TeamDao teamDao;

    @Override
    public List<Map<String, Object>> getTeamTaskListByTId(String teamId) {
        Team team = teamDao.findDetailsById(teamId);
        List<Task> allTask = taskDao.findAllByTeacherId(team.getTeacherId());
        List<Student> students = team.getStudents();

        List<Map<String,Object>> res = new ArrayList<>();
        for(int i = 0;i<allTask.size();i++){
            Task cTask = allTask.get(i);
            Map<String,Object> m = new HashMap<>();
            m.put("id",cTask.getId());
            m.put("eSTime",cTask.getESTime());
            m.put("deadline",cTask.getDeadline());
            m.put("fSLimit",cTask.getFSLimit());
            m.put("students",students);
            m.put("name",cTask.getName());
            List<Double> proportions = new ArrayList<>();
            for(Student student:students){
                Double proportion = taskDao.findProportion(student.getId(), cTask.getId());
                proportions.add(proportion);
            }
            m.put("proportions",proportions);
            TeamTask teamTask = taskDao.findTeamTask(team.getId(),cTask.getId());
            m.put("state",teamTask.getState());
            m.put("score",teamTask.getScore());
            m.put("remark",teamTask.getRemark());
            res.add(m);
        }
        return res;
    }
}
