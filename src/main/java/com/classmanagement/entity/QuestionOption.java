package com.classmanagement.entity;

public class QuestionOption {

    private Integer id;
    private Integer questionId;
    private String content;
    private Integer number;

    public QuestionOption(Integer id, Integer questionId, String content, Integer number) {
        this.id = id;
        this.questionId = questionId;
        this.content = content;
        this.number = number;
    }

    @Override
    public String toString() {
        return "QuestionOption{" +
                "id=" + id +
                ", questionId=" + questionId +
                ", content='" + content + '\'' +
                ", number=" + number +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public QuestionOption(Integer questionId, String content, Integer number) {
        this.questionId = questionId;
        this.content = content;
        this.number = number;
    }

    public QuestionOption() {
    }
}
