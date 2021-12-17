package com.xiao.service.imp;

import com.xiao.dao.StudentDao;
import com.xiao.dao.TeamDao;
import com.xiao.dao.TopicDao;
import com.xiao.pojo.Student;
import com.xiao.pojo.Team;
import com.xiao.pojo.Topic;
import com.xiao.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class TopicServiceImp implements TopicService {

    @Autowired
    private TopicDao topicDao;

    @Autowired
    private TeamDao teamDao;

    @Autowired
    private StudentDao studentDao;

    @Override
    public Topic findById(String id) {
        Topic topic = topicDao.findById(id);
        return topic;
    }

    @Override
    public void addTopic(Topic topic) {

    }

    @Override
    public void update(Topic topic) {

    }

    @Override
    public List<Topic> findAllByTeacherId(String id) {
        List<Topic> all = topicDao.findAllByTeacherId(id);
        return all;
    }

    @Override
    public List<Topic> findAllByStudentId(String id) {
        Student student = studentDao.findById(id);
        Team team = teamDao.findById(student.getTeamId());
        return findAllByTeacherId(team.getTeacherId());
    }
}
