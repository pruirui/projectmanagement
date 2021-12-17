package com.xiao.service.imp;

import com.xiao.dao.*;
import com.xiao.pojo.Student;
import com.xiao.pojo.StudentTask;
import com.xiao.pojo.Team;
import com.xiao.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class TeamServiceImp implements TeamService {

    @Autowired
    private TeamDao teamDao;

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private StudentTaskDao studentTaskDao;
    @Autowired
    private TeamTaskDao teamTaskDao;
    @Autowired
    private DocumentDao documentDao;

    @Override
    public void addToTeam(String id, String studentId) {

    }

    @Override
    public void goAwayTeam(String studentId) {
        Student student = studentDao.findById(studentId);
        if(student.getRole()==0) return;
        if(student.getRole() == 2){
            Team team = findDetailsById(student.getTeamId());
            List<Student> students = team.getStudents();
            teamTaskDao.deleteByTeamId(team.getId());
            for(Student student1:students){
                student1.setRole(0);
                studentTaskDao.deleteBySId(student1.getId());
                documentDao.deleteByStudentId(student1.getId());
                studentDao.update(student1);
            }
            teamTaskDao.deleteByTeamId(student.getTeamId());
            teamDao.deleteById(student.getTeamId());
        }else if(student.getRole() == 1){
            student.setRole(0);
            studentTaskDao.deleteBySId(student.getId());
            documentDao.deleteByStudentId(student.getId());
            studentDao.update(student);
        }
    }

    @Override
    public Team findDetailsById(String id) {
        return teamDao.findDetailsById(id);
    }

    @Override
    public Team findById(String id) {
        return teamDao.findById(id);
    }

    @Override
    public void setTopic(String topicId, String teamId) {
        Team team = teamDao.findById(topicId);
        team.setTopic(topicId);
        teamDao.update(team);
    }
}
