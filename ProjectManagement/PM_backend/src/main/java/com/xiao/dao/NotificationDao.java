package com.xiao.dao;

import com.xiao.pojo.Notification;

import java.util.List;

public interface NotificationDao {

    List<Notification> findByTeacherId(String teacherId);
    Notification findById(Integer id);
    void add(Notification notification);
    void deleteById(Integer id);
}
