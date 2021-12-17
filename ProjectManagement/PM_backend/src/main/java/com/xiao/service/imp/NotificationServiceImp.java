package com.xiao.service.imp;

import com.xiao.dao.NotificationDao;
import com.xiao.dao.StudentDao;
import com.xiao.dao.TeacherDao;
import com.xiao.dao.TeamDao;
import com.xiao.pojo.Notification;
import com.xiao.pojo.Student;
import com.xiao.pojo.Teacher;
import com.xiao.pojo.Team;
import com.xiao.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@Transactional
public class NotificationServiceImp implements NotificationService {

    @Autowired
    private NotificationDao notificationDao;

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private TeamDao teamDao;
    @Autowired
    private TeacherDao teacherDao;

    @Override
    public List<Notification> getNotificationListByTeacherId(String teacherId) {
        List<Notification> notifications = notificationDao.findByTeacherId(teacherId);
        return notifications;
    }

    @Override
    public List<Notification> getNotificationListByStudentId(String studentId) {
        Student student = studentDao.findById(studentId);
        if(student.getTeamId() == null){
            return new ArrayList<>();
        }
        Team team = teamDao.findById(student.getTeamId());
        List<Notification> notifications = notificationDao.findByTeacherId(team.getTeacherId());
        return notifications;
    }
    @Override
    public List<Map<String,String>> getNotificationListAndTeacherByStudentId(String studentId) {
        Student student = studentDao.findById(studentId);
        List<Map<String,String>> res = new ArrayList<>();
        if(student.getTeamId() == null){
            return res;
        }
        Team team = teamDao.findById(student.getTeamId());
        List<Notification> notifications = notificationDao.findByTeacherId(team.getTeacherId());
        Teacher teacher = teacherDao.findById(team.getTeacherId());
        for (Notification notification : notifications) {
            res.add(new HashMap<String, String>() {
                {
                    put("id", String.valueOf(notification.getId()));
                    put("title", notification.getTitle());
                    put("tname", teacher.getName());
                }
            });
        }
        return res;
    }

    @Override
    public Notification getNotificationById(String id) {
        return null;
    }
}
