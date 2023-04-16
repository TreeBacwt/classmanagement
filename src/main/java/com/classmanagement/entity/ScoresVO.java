package com.classmanagement.entity;

public class ScoresVO {

    private String studentName;
    private Float english;
    private Float math;
    private Float chinese;
    private Float computer;

    @Override
    public String toString() {
        return "ScoresVO{" +
                "studentName='" + studentName + '\'' +
                ", english=" + english +
                ", math=" + math +
                ", chinese=" + chinese +
                ", computer=" + computer +
                '}';
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
    }

    public ScoresVO() {
    }
}
