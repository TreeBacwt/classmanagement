package com.classmanagement.entity;

public class Score {

    private Integer subjectId;
    private Integer examinationId;
    private Integer studentNum;
    private Float score;

    public Score() {
    }

    public Score(Integer subjectId, Integer examinationId, Integer studentNum, Float score) {
        this.subjectId = subjectId;
        this.examinationId = examinationId;
        this.studentNum = studentNum;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Score{" +
                "subjectId=" + subjectId +
                ", examinationId=" + examinationId +
                ", studentNum=" + studentNum +
                ", score=" + score +
                '}';
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getExaminationId() {
        return examinationId;
    }

    public void setExaminationId(Integer examinationId) {
        this.examinationId = examinationId;
    }

    public Integer getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(Integer studentNum) {
        this.studentNum = studentNum;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }
}
