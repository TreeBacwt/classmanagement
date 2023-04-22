package com.classmanagement.entity;

public class Answer {

    private Integer questionId;
    private Integer questionOptionId;
    private Integer parentId;

    @Override
    public String toString() {
        return "Answer{" +
                "questionId=" + questionId +
                ", questionOptionId=" + questionOptionId +
                ", parentId=" + parentId +
                '}';
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getQuestionOptionId() {
        return questionOptionId;
    }

    public void setQuestionOptionId(Integer questionOptionId) {
        this.questionOptionId = questionOptionId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Answer(Integer questionId, Integer questionOptionId, Integer parentId) {
        this.questionId = questionId;
        this.questionOptionId = questionOptionId;
        this.parentId = parentId;
    }

    public Answer() {
    }
}
