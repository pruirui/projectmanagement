package com.xiao.service;

import com.xiao.pojo.Notification;

import java.util.List;
import java.util.Map;

public interface NotificationService {
    List<Notification> getNotificationListByTeacherId(String teacherId);
    List<Notification> getNotificationListByStudentId(String studentId);
    List<Map<String,String>> getNotificationListAndTeacherByStudentId(String studentId);

    Notification getNotificationById(String id);
}
