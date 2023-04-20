package com.classmanagement.entity;

import java.util.List;

public class QuestionnaireWithQuestionsAndOptionsVO {

    private Questionnaire questionnaire;
    private List<QuestionWithOptionsVO> questions;

    @Override
    public String toString() {
        return "QuestionnaireWithQuestionsAndOptionsVO{" +
                "questionnaire=" + questionnaire +
                ", questions=" + questions +
                '}';
    }

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }

    public List<QuestionWithOptionsVO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionWithOptionsVO> questions) {
        this.questions = questions;
    }

    public QuestionnaireWithQuestionsAndOptionsVO(Questionnaire questionnaire, List<QuestionWithOptionsVO> questions) {
        this.questionnaire = questionnaire;
        this.questions = questions;
    }

    public QuestionnaireWithQuestionsAndOptionsVO() {
    }
}
