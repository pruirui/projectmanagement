package com.xiao.service.imp;

import com.xiao.constant.MessageConstant;
import com.xiao.dao.StudentDao;
import com.xiao.dao.TeacherDao;
import com.xiao.entity.Result;
import com.xiao.pojo.Student;
import com.xiao.pojo.Teacher;
import com.xiao.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoginServiceImp implements LoginService {

    @Autowired
    private TeacherDao teacherDao;

    @Autowired
    private StudentDao studentDao;

    @Override
    public Result teacherLogin(Teacher teacher) {
        Teacher t = teacherDao.findById(teacher.getId());
        if(t == null || !t.getPassword().equals(teacher.getPassword())){
            return new Result(false, MessageConstant.LOGIN_FAIL);
        }
        return new Result(true,MessageConstant.LOGIN_SUCCESS,t);
    }

    @Override
    public Result studentLogin(Student student) {
        Student t = studentDao.findById(student.getId());
        if(t == null || !t.getPassword().equals(student.getPassword())){
            return new Result(false, MessageConstant.LOGIN_FAIL);
        }
        return new Result(true,MessageConstant.LOGIN_SUCCESS,t);
    }

    @Override
    public Result register(Teacher teacher) {
        try {
            teacherDao.add(teacher);
            return new Result(true,MessageConstant.REGISTER_SUCCESS);
        }catch (Exception e){
            return new Result(false,MessageConstant.REGISTER_FAIL);
        }
    }
}
