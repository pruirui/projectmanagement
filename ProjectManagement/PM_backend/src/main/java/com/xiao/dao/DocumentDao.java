package com.xiao.dao;

import com.xiao.pojo.Document;

public interface DocumentDao {
    Document findByPath(String path);
    void add(Document document);
    void deleteByPath(String path);
    void deleteByStudentId(String studentId);
    void deleteByTaskId(String taskId);
}
