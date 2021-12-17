package com.xiao.service;

import com.xiao.pojo.Topic;
import net.sf.jsqlparser.statement.select.Top;

import java.util.List;

public interface TopicService {
    Topic findById(String id);
    void addTopic(Topic topic);
    void update(Topic topic);
    List<Topic> findAllByTeacherId(String id);
    List<Topic> findAllByStudentId(String id);
}
