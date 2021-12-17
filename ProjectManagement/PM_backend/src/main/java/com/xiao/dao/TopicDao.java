package com.xiao.dao;

import com.xiao.pojo.Topic;

import java.util.List;

public interface TopicDao {

    List<Topic> findAllByTeacherId(String id);
    void addTopic(Topic topic);
    Topic findById(String id);
    void update(Topic topic);
    void deleteById(String id);
}
