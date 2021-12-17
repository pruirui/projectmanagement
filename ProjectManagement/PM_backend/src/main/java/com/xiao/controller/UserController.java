package com.xiao.controller;


import com.sun.tools.hat.internal.model.ReachableExcludes;
import com.xiao.constant.MessageConstant;
import com.xiao.entity.Result;
import com.xiao.pojo.Student;
import com.xiao.pojo.Teacher;
import com.xiao.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/tlogin")
    public Result tlogin(@RequestBody Teacher teacher, HttpServletRequest httpServletRequest){
        Result result = loginService.teacherLogin(teacher);
        if(result.isFlag()){
            httpServletRequest.getSession().setAttribute(MessageConstant.LOGIN_USER,result.getData());
            httpServletRequest.getSession().setAttribute(MessageConstant.LOGIN_STATUS,MessageConstant.LOGIN_STATUS_TEACHER);
        }
        return result;
    }


    @RequestMapping("/slogin")
    public Result slogin(@RequestBody Student student, HttpServletRequest httpServletRequest){
        Result result = loginService.studentLogin(student);
        System.out.println(httpServletRequest.getSession().getId());
        if(result.isFlag()){
            httpServletRequest.getSession().setAttribute(MessageConstant.LOGIN_USER,result.getData());
            httpServletRequest.getSession().setAttribute(MessageConstant.LOGIN_STATUS,MessageConstant.LOGIN_STATUS_STUDENT);
        }
        return result;
    }


    @RequestMapping("/logOut")
    public void loginOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().invalidate();
        response.sendRedirect("/login.html");
    }

    @RequestMapping("/register")
    public Result register(@RequestBody Teacher teacher){
        Result result = loginService.register(teacher);
        return result;
    }

    @RequestMapping("/getUserInfo")
    public Result getUserInfo(HttpServletRequest request){
        Result result = new Result(true,"获取用户信息",request.getSession().getAttribute(MessageConstant.LOGIN_USER));
        return result;
    }


}
