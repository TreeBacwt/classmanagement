package com.classmanagement.entity;

import java.util.List;

public class QuestionWithOptionsVO {

    private Question question;
    private List<QuestionOption> options;

    @Override
    public String toString() {
        return "QuestionWithOptionsVO{" +
                "question=" + question +
                ", options=" + options +
                '}';
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public List<QuestionOption> getOptions() {
        return options;
    }

    public void setOptions(List<QuestionOption> options) {
        this.options = options;
    }

    public QuestionWithOptionsVO() {
    }

    public QuestionWithOptionsVO(Question question, List<QuestionOption> options) {
        this.question = question;
        this.options = options;
    }
}
