package com.classmanagement.entity;

import java.util.List;

public class ExaminationWithScoresVO {

    private Examination examination;
    private List<Score> scores;

    @Override
    public String toString() {
        return "ExaminationWithScoresVO{" +
                "examination=" + examination +
                ", scores=" + scores +
                '}';
    }

    public Examination getExamination() {
        return examination;
    }

    public void setExamination(Examination examination) {
        this.examination = examination;
    }

    public List<Score> getScores() {
        return scores;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }

    public ExaminationWithScoresVO(Examination examination, List<Score> scores) {
        this.examination = examination;
        this.scores = scores;
    }

    public ExaminationWithScoresVO() {
    }
}
