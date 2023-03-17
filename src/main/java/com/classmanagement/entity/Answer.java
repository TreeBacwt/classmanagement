package com.classmanagement.entity;

public class Answer {

    private Integer questionId;
    private String content;
    private Integer parentId;

    @Override
    public String toString() {
        return "Answer{" +
                "questionId=" + questionId +
                ", content='" + content + '\'' +
                ", parentId=" + parentId +
                '}';
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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Answer(Integer questionId, String content, Integer parentId) {
        this.questionId = questionId;
        this.content = content;
        this.parentId = parentId;
    }

    public Answer() {
    }
}
