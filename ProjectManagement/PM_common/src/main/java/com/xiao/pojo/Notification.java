package com.xiao.pojo;


public class Notification {

  private String remark;
  private String teacherId;
  private java.sql.Date time;
  private String title;
  private int id;


  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }


  public String getTeacherId() {
    return teacherId;
  }

  public void setTeacherId(String teacherId) {
    this.teacherId = teacherId;
  }


  public java.sql.Date getTime() {
    return time;
  }

  public void setTime(java.sql.Date time) {
    this.time = time;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

}
