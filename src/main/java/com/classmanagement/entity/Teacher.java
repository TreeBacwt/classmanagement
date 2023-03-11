package com.classmanagement.entity;

public class Teacher {
    private Integer id;
    private String teacherName;
    private Integer sex;
    private String subject;
    private String information;
    private Integer userId;

    public Teacher() {
    }

    public Teacher(Integer id, String teacherName, Integer sex, String subject, String information, Integer userId) {
        this.id = id;
        this.teacherName = teacherName;
        this.sex = sex;
        this.subject = subject;
        this.information = information;
        this.userId = userId;
    }

    public Teacher(String teacherName, Integer sex, String subject, String information, Integer userId) {
        this.teacherName = teacherName;
        this.sex = sex;
        this.subject = subject;
        this.information = information;
        this.userId = userId;
    }

    public Teacher(String teacherName, Integer sex, String subject, String information) {
        this.teacherName = teacherName;
        this.sex = sex;
        this.subject = subject;
        this.information = information;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", teacherName='" + teacherName + '\'' +
                ", sex=" + sex +
                ", subject='" + subject + '\'' +
                ", information='" + information + '\'' +
                ", userId=" + userId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
