package com.xiao.service.imp;

import com.xiao.dao.InvitationDao;
import com.xiao.pojo.Student;
import com.xiao.service.InvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class InvitationServiceImp implements InvitationService {

    @Autowired
    private InvitationDao invitationDao;


    @Override
    public List<List<String>> getInvitationListByStudentEdId(String id) {
        List<List<String>> res = new ArrayList<>();
        List<Student> students = invitationDao.findInvitationListByStudentEdId(id);
        for(Student student: students){
            res.add(new ArrayList<String>(){{add(student.getId());add(student.getName());}});
        }
        return res;
    }

    @Override
    public List<List<String>> getInvitationListByStudentId(String id) {
        List<List<String>> res = new ArrayList<>();
        List<Student> students = invitationDao.findInvitationListByStudentId(id);
        for(Student student: students){
            res.add(new ArrayList<String>(){{add(student.getId());add(student.getName());}});
        }
        return res;
    }
}
