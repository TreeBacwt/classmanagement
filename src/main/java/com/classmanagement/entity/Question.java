package com.classmanagement.entity;

public class Question {

    private Integer id;
    private String description;
    private Integer number;
    private Integer type;
    private Integer questionnaireId;

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", number=" + number +
                ", type=" + type +
                ", questionnaireId=" + questionnaireId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(Integer questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    public Question(String description, Integer number, Integer type, Integer questionnaireId) {
        this.description = description;
        this.number = number;
        this.type = type;
        this.questionnaireId = questionnaireId;
    }

    public Question(Integer id, String description, Integer number, Integer type, Integer questionnaireId) {
        this.id = id;
        this.description = description;
        this.number = number;
        this.type = type;
        this.questionnaireId = questionnaireId;
    }

    public Question() {
    }
}
