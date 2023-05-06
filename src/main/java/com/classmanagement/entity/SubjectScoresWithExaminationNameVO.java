package com.classmanagement.entity;

public class SubjectScoresWithExaminationNameVO {

    private Float score;
    private String examinationName;

    @Override
    public String toString() {
        return "SubjectScoresWithExaminationNameVO{" +
                "score=" + score +
                ", examinationName='" + examinationName + '\'' +
                '}';
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public String getExaminationName() {
        return examinationName;
    }

    public void setExaminationName(String examinationName) {
        this.examinationName = examinationName;
    }

    public SubjectScoresWithExaminationNameVO() {
    }

    public SubjectScoresWithExaminationNameVO(Float score, String examinationName) {
        this.score = score;
        this.examinationName = examinationName;
    }
}
