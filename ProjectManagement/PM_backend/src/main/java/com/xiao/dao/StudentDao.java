package com.xiao.dao;

import com.xiao.pojo.Student;
import com.xiao.pojo.Teacher;

import java.util.List;

public interface StudentDao {
    Student findById(String id);
    void add(Student student);
    void deleteById(String id);
    void update(Student student);
    List<Student> findStudentsByTeamId(String teamId);
}
