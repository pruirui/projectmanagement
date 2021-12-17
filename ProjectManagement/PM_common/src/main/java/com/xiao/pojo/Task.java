package com.xiao.pojo;


import java.util.Date;

public class Task {

  private String id;
  private String teacherId;
  private String name;
  private Date eSTime;
  private Date deadline;
  private double score;
  private long fSLimit;
  private String remark;
  private String templatePath;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getTeacherId() {
    return teacherId;
  }

  public void setTeacherId(String teacherId) {
    this.teacherId = teacherId;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public Date getESTime() {
    return eSTime;
  }

  public void setESTime(Date eSTime) {
    this.eSTime = eSTime;
  }


  public Date getDeadline() {
    return deadline;
  }

  public void setDeadline(Date deadline) {
    this.deadline = deadline;
  }


  public double getScore() {
    return score;
  }

  public void setScore(double score) {
    this.score = score;
  }


  public long getFSLimit() {
    return fSLimit;
  }

  public void setFSLimit(long fSLimit) {
    this.fSLimit = fSLimit;
  }


  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }


  public String getTemplatePath() {
    return templatePath;
  }

  public void setTemplatePath(String templatePath) {
    this.templatePath = templatePath;
  }

}
