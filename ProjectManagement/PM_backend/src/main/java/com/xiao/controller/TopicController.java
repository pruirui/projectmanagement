package com.xiao.controller;


import com.xiao.constant.MessageConstant;
import com.xiao.entity.Result;
import com.xiao.pojo.Student;
import com.xiao.pojo.Teacher;
import com.xiao.pojo.Topic;
import com.xiao.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    private TopicService topicService;


    @RequestMapping("/findAll")
    public Result findAll(HttpServletRequest request){
        HttpSession session = request.getSession();
        if(session.getAttribute(MessageConstant.LOGIN_STATUS).toString().equals(MessageConstant.LOGIN_STATUS_TEACHER)){
            Teacher teacher = (Teacher) session.getAttribute(MessageConstant.LOGIN_USER);
            List<Topic> all = topicService.findAllByTeacherId(teacher.getId());
            return new Result(true, MessageConstant.FIND_SUCCESS,all);
        }else {
            Student student = (Student) session.getAttribute(MessageConstant.LOGIN_USER);
            List<Topic> all = topicService.findAllByStudentId(student.getId());
            return new Result(true, MessageConstant.FIND_SUCCESS,all);
        }
    }

    @RequestMapping("/findById")
    public Result findById(String id){
        Topic topic = topicService.findById(id);
        return new Result(true,MessageConstant.FIND_SUCCESS,topic);
    }
}
