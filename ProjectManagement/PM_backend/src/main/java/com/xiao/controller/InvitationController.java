package com.xiao.controller;


import com.xiao.constant.MessageConstant;
import com.xiao.entity.Result;
import com.xiao.pojo.Student;
import com.xiao.service.InvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/invitation")
public class InvitationController {

    @Autowired
    private InvitationService invitationService;

    @RequestMapping("/getInvitationList")
    public Result getInvitationList(HttpServletRequest request){
        Student student = (Student)request.getSession().getAttribute(MessageConstant.LOGIN_USER);
        List<List<String>> invitations = invitationService.getInvitationListByStudentEdId(student.getId());
        return new Result(true,MessageConstant.FIND_INVITATION_SUCCESS,invitations);
    }
}
