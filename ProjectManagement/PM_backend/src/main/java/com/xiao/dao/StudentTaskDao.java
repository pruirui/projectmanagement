package com.xiao.dao;

import com.xiao.pojo.StudentTask;
import org.apache.ibatis.annotations.Param;

public interface StudentTaskDao {
    StudentTask findBySIdAndTId(@Param("studentId") String studentId,@Param("taskId") String taskId);
    void deleteBySIdAndTId(@Param("studentId") String studentId,@Param("taskId") String taskId);
    void add(StudentTask studentTask);
    void deleteBySId(String studentId);
    void deleteByTId(String taskId);

}
