package com.xiao.service;

import com.xiao.entity.Result;
import com.xiao.pojo.Student;
import com.xiao.pojo.Teacher;

public interface LoginService {

     Result teacherLogin(Teacher teacher);

     Result studentLogin(Student student);

     Result register(Teacher teacher);
}
