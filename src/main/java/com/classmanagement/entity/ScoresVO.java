package com.classmanagement.entity;

import java.util.HashMap;

public class ScoresVO {

    private String studentName;
    private Integer studentNum;
    private Integer isEdit;
    private HashMap<String, Float> scores;

    @Override
    public String toString() {
        return "ScoresVO{" +
                "studentName='" + studentName + '\'' +
                ", studentNum=" + studentNum +
                ", isEdit=" + isEdit +
                ", scores=" + scores +
                '}';
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(Integer studentNum) {
        this.studentNum = studentNum;
    }

    public Integer getIsEdit() {
        return isEdit;
    }

    public void setIsEdit(Integer isEdit) {
        this.isEdit = isEdit;
    }

    public HashMap<String, Float> getScores() {
        return scores;
    }

    public void setScores(HashMap<String, Float> scores) {
        this.scores = scores;
    }

    public ScoresVO(String studentName, Integer studentNum, Integer isEdit, HashMap<String, Float> scores) {
        this.studentName = studentName;
        this.studentNum = studentNum;
        this.isEdit = isEdit;
        this.scores = scores;
    }

    public ScoresVO() {
    }
}
