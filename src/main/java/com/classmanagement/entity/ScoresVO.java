package com.classmanagement.entity;

public class ScoresVO {

    private String studentName;
    private Integer studentNum;
    private Float english;
    private Float math;
    private Float chinese;
    private Float computer;
    private Integer isEdit;

    public Integer getIsEdit() {
        return isEdit;
    }

    public void setIsEdit(Integer isEdit) {
        this.isEdit = isEdit;
    }

    public Integer getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(Integer studentNum) {
        this.studentNum = studentNum;
    }

    public ScoresVO(String studentName, Integer studentNum, Float english, Float math, Float chinese, Float computer) {
        this.studentName = studentName;
        this.studentNum = studentNum;
        this.english = english;
        this.math = math;
        this.chinese = chinese;
        this.computer = computer;
        this.isEdit = 0;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Float getEnglish() {
        return english;
    }

    public void setEnglish(Float english) {
        this.english = english;
    }

    public Float getMath() {
        return math;
    }

    public void setMath(Float math) {
        this.math = math;
    }

    public Float getChinese() {
        return chinese;
    }

    public void setChinese(Float chinese) {
        this.chinese = chinese;
    }

    @Override
    public String toString() {
        return "ScoresVO{" +
                "studentName='" + studentName + '\'' +
                ", studentNum=" + studentNum +
                ", english=" + english +
                ", math=" + math +
                ", chinese=" + chinese +
                ", computer=" + computer +
                ", isEdit=" + isEdit +
                '}';
    }

    public Float getComputer() {
        return computer;
    }

    public void setComputer(Float computer) {
        this.computer = computer;
    }

    public ScoresVO(String studentName, Float english, Float math, Float chinese, Float computer) {
        this.studentName = studentName;
        this.english = english;
        this.math = math;
        this.chinese = chinese;
        this.computer = computer;
        this.isEdit = 0;
    }

    public ScoresVO() {
        this.isEdit = 0;
    }
}
