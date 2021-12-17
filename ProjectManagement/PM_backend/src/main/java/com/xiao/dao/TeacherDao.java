package com.xiao.dao;

import com.xiao.pojo.Teacher;

public interface TeacherDao {
    Teacher findById(String id);
    void add(Teacher teacher);
    void deleteById(String id);
    void update(Teacher teacher);
}
