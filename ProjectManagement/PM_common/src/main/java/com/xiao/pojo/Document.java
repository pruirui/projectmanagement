package com.xiao.pojo;


import java.util.Date;

public class Document {

  private String path;
  private String filename;
  private Date uploadTime;
  private String remarks;
  private String studentId;
  private String taskId;


  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }


  public String getFilename() {
    return filename;
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }


  public String getRemarks() {
    return remarks;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }


  public String getStudentId() {
    return studentId;
  }

  public void setStudentId(String studentId) {
    this.studentId = studentId;
  }

  public void setUploadTime(Date uploadTime) {
    this.uploadTime = uploadTime;
  }
  public Date getUploadTime() {
    return uploadTime;
  }

  public String getTaskId() {
    return taskId;
  }

  public void setTaskId(String taskId) {
    this.taskId = taskId;
  }
}
