package com.xiao.controller;


import com.xiao.constant.MessageConstant;
import com.xiao.entity.Result;
import com.xiao.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @RequestMapping("/getTeamTaskListByTId")
    public Result getTeamTaskListByTId(@RequestParam("id") String id){
        List<Map<String, Object>> res = taskService.getTeamTaskListByTId(id);
        return new Result(true, MessageConstant.FIND_TASK_TEAM_SUCCESS,res);
    }
}
