package com.xiao.controller;


import com.xiao.constant.MessageConstant;
import com.xiao.entity.Result;
import com.xiao.pojo.Student;
import com.xiao.pojo.Team;
import com.xiao.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @RequestMapping("/getTeamAllById")
    public Result getTeamAllById(@RequestParam("id") String id){
        Team detailsTeam = teamService.findDetailsById(id);
        return new Result(true, MessageConstant.FIND_TEAM_DETAIL_SUCCESS,detailsTeam);
    }

    @RequestMapping("/goAway")
    public Result goAway(@RequestParam("id") String id, HttpServletRequest request){
        teamService.goAwayTeam(id);
        return new Result(true,MessageConstant.GO_AWAY_TEAM_SUCCESS);
    }

    @RequestMapping("/setTopic")
    public Result setTopic(@RequestParam("id")String id,HttpServletRequest request){
        Student student = (Student)request.getSession().getAttribute(MessageConstant.LOGIN_USER);
        teamService.setTopic(id,student.getId());
        return new Result(true,MessageConstant.MODIFY_SUCCESS);
    }

}
