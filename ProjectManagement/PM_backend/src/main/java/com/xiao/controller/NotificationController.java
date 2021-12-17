package com.xiao.controller;

import com.sun.javafx.collections.MappingChange;
import com.xiao.constant.MessageConstant;
import com.xiao.entity.Result;
import com.xiao.pojo.Notification;
import com.xiao.pojo.Student;
import com.xiao.pojo.Teacher;
import com.xiao.service.NotificationService;
import com.xiao.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/notification")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @RequestMapping("/getNotificationList")
    public Result getNotificationList(HttpServletRequest request){

        HttpSession session = request.getSession();
        if(session.getAttribute(MessageConstant.LOGIN_STATUS).toString().equals(MessageConstant.LOGIN_STATUS_TEACHER)){
            Teacher teacher = (Teacher) session.getAttribute(MessageConstant.LOGIN_USER);
            List<Notification> notifications = notificationService.getNotificationListByTeacherId(teacher.getId());
            List<Map<String,String>> res = new ArrayList<>();
            for (Notification notification : notifications) {
                res.add(new HashMap<String,String>(){
                    {   put("id",String.valueOf(notification.getId()));
                        put("title",notification.getTitle());
                        put("tname",teacher.getName());
                    }
                });
            }
            return new Result(true,MessageConstant.FIND_NOTIFICATION_SUCCESS,res);
        }else{
            Student student = (Student) session.getAttribute(MessageConstant.LOGIN_USER);
            List<Map<String,String>> res = notificationService.getNotificationListAndTeacherByStudentId(student.getId());
            return new Result(true,MessageConstant.FIND_NOTIFICATION_SUCCESS,res);
        }
    }
}
