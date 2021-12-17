package com.xiao.dao;

import com.xiao.pojo.Student;

import java.util.List;

public interface InvitationDao {
    List<Student> findInvitationListByStudentEdId(String id);
    List<Student> findInvitationListByStudentId(String id);
}
