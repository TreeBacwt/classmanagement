package com.classmanagement.entity;

public class Parent {

    private Integer id;
    private String parentName;
    private Integer studentNum;
    private Integer userId;
    private String information;

    public Parent() {
    }

    public Parent(Integer id, String parentName, Integer studentNum, Integer userId, String information) {
        this.id = id;
        this.parentName = parentName;
        this.studentNum = studentNum;
        this.userId = userId;
        this.information = information;
    }

    public Parent(String parentName, Integer studentNum, Integer userId, String information) {
        this.parentName = parentName;
        this.studentNum = studentNum;
        this.userId = userId;
        this.information = information;
    }

    @Override
    public String toString() {
        return "Parent{" +
                "id=" + id +
                ", parentName='" + parentName + '\'' +
                ", studentNum=" + studentNum +
                ", userId=" + userId +
                ", information='" + information + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public Integer getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(Integer studentNum) {
        this.studentNum = studentNum;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }
}
