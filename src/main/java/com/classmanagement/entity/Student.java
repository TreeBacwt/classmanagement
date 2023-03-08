package com.classmanagement.entity;

import java.util.Date;

public class Student {
    private Integer studentNum;
    private String studentName;
    private Integer sex;
    private Integer userId;
    private Date birthday;
    private String address;
    private String ethnic;
    private String information;
    private Integer isLeader;

    public Student() {
    }
    public Student(Integer studentNum, String studentName, Integer sex, Integer userId, Date birthday, String address, String ethnic, String information, Integer isLeader) {
        this.studentNum = studentNum;
        this.studentName = studentName;
        this.sex = sex;
        this.userId = userId;
        this.birthday = birthday;
        this.address = address;
        this.ethnic = ethnic;
        this.information = information;
        this.isLeader = isLeader;
    }

    public Student(String studentName, Integer sex, Integer userId, Date birthday, String address, String ethnic, String information, Integer isLeader) {
        this.studentName = studentName;
        this.sex = sex;
        this.userId = userId;
        this.birthday = birthday;
        this.address = address;
        this.ethnic = ethnic;
        this.information = information;
        this.isLeader = isLeader;
    }

    public Student(String studentName, Integer sex, Date birthday, String address, String ethnic, String information, Integer isLeader) {
        this.studentName = studentName;
        this.sex = sex;
        this.birthday = birthday;
        this.address = address;
        this.ethnic = ethnic;
        this.information = information;
        this.isLeader = isLeader;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentNum=" + studentNum +
                ", studentName='" + studentName + '\'' +
                ", sex=" + sex +
                ", userId=" + userId +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                ", ethnic='" + ethnic + '\'' +
                ", information='" + information + '\'' +
                ", isLeader=" + isLeader +
                '}';
    }

    public Integer getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(Integer studentNum) {
        this.studentNum = studentNum;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEthnic() {
        return ethnic;
    }

    public void setEthnic(String ethnic) {
        this.ethnic = ethnic;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public Integer getIsLeader() {
        return isLeader;
    }

    public void setIsLeader(Integer isLeader) {
        this.isLeader = isLeader;
    }
}
