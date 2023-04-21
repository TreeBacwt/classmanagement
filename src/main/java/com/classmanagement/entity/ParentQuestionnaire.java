package com.classmanagement.entity;

public class ParentQuestionnaire {

    private Integer parentId;
    private Integer questionnaireId;
    private Integer isDone;

    @Override
    public String toString() {
        return "ParentQuestionnaire{" +
                "parentId=" + parentId +
                ", questionnaireId=" + questionnaireId +
                ", isDone=" + isDone +
                '}';
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(Integer questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    public Integer getIsDone() {
        return isDone;
    }

    public void setIsDone(Integer isDone) {
        this.isDone = isDone;
    }

    public ParentQuestionnaire() {
    }

    public ParentQuestionnaire(Integer parentId, Integer questionnaireId, Integer isDone) {
        this.parentId = parentId;
        this.questionnaireId = questionnaireId;
        this.isDone = isDone;
    }
}
