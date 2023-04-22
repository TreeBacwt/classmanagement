package com.classmanagement.entity;

import java.util.Date;

public class Vote {

    private Integer id;
    private String voteName;
    private String information;
    private Date voteDate;
    private Date overDate;
    private Integer isOver;
    private Integer participant;
    private Integer optionsNumber;

    public Vote() {
    }

    public Date getOverDate() {
        return overDate;
    }

    public void setOverDate(Date overDate) {
        this.overDate = overDate;
    }

    public Vote(String voteName, String information, Date voteDate, Date overDate, Integer isOver, Integer participant, Integer optionsNumber) {
        this.voteName = voteName;
        this.information = information;
        this.voteDate = voteDate;
        this.overDate = overDate;
        this.isOver = isOver;
        this.participant = participant;
        this.optionsNumber = optionsNumber;
    }

    public Vote(Integer id, String voteName, String information, Date voteDate, Date overDate, Integer isOver, Integer participant, Integer optionsNumber) {
        this.id = id;
        this.voteName = voteName;
        this.information = information;
        this.voteDate = voteDate;
        this.overDate = overDate;
        this.isOver = isOver;
        this.participant = participant;
        this.optionsNumber = optionsNumber;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "id=" + id +
                ", voteName='" + voteName + '\'' +
                ", information='" + information + '\'' +
                ", voteDate=" + voteDate +
                ", overDate=" + overDate +
                ", isOver=" + isOver +
                ", participant=" + participant +
                ", optionsNumber=" + optionsNumber +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVoteName() {
        return voteName;
    }

    public void setVoteName(String voteName) {
        this.voteName = voteName;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public Date getVoteDate() {
        return voteDate;
    }

    public void setVoteDate(Date voteDate) {
        this.voteDate = voteDate;
    }

    public Integer getIsOver() {
        return isOver;
    }

    public void setIsOver(Integer isOver) {
        this.isOver = isOver;
    }

    public Integer getParticipant() {
        return participant;
    }

    public void setParticipant(Integer participant) {
        this.participant = participant;
    }

    public Integer getOptionsNumber() {
        return optionsNumber;
    }

    public void setOptionsNumber(Integer optionsNumber) {
        this.optionsNumber = optionsNumber;
    }
}
