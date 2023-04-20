package com.classmanagement.entity;

import java.util.Date;

public class Questionnaire {

    private Integer id;
    private String questionnaireName;
    private Date questionnaireDate;
    private String information;
    private Integer respondent;
    private Integer isOver;
    private Date overDate;

    @Override
    public String toString() {
        return "Questionnaire{" +
                "id=" + id +
                ", questionnaireName='" + questionnaireName + '\'' +
                ", questionnaireDate=" + questionnaireDate +
                ", information='" + information + '\'' +
                ", respondent=" + respondent +
                ", isOver=" + isOver +
                ", overDate=" + overDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestionnaireName() {
        return questionnaireName;
    }

    public void setQuestionnaireName(String questionnaireName) {
        this.questionnaireName = questionnaireName;
    }

    public Date getQuestionnaireDate() {
        return questionnaireDate;
    }

    public void setQuestionnaireDate(Date questionnaireDate) {
        this.questionnaireDate = questionnaireDate;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public Integer getRespondent() {
        return respondent;
    }

    public void setRespondent(Integer respondent) {
        this.respondent = respondent;
    }

    public Integer getIsOver() {
        return isOver;
    }

    public void setIsOver(Integer isOver) {
        this.isOver = isOver;
    }

    public Date getKeepTime() {
        return overDate;
    }

    public void setOverDate(Date overDate) {
        this.overDate = overDate;
    }

    public Questionnaire(String questionnaireName, Date questionnaireDate, String information, Integer respondent, Integer isOver, Date overDate) {
        this.questionnaireName = questionnaireName;
        this.questionnaireDate = questionnaireDate;
        this.information = information;
        this.respondent = respondent;
        this.isOver = isOver;
        this.overDate = overDate;
    }

    public Questionnaire(Integer id, String questionnaireName, Date questionnaireDate, String information, Integer respondent, Integer isOver, Date overDate) {
        this.id = id;
        this.questionnaireName = questionnaireName;
        this.questionnaireDate = questionnaireDate;
        this.information = information;
        this.respondent = respondent;
        this.isOver = isOver;
        this.overDate = overDate;
    }

    public Questionnaire() {
    }
}
