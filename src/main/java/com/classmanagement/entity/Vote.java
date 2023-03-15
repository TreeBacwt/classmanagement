package com.classmanagement.entity;

import java.util.Date;

public class Vote {

    private Integer id;
    private String voteName;
    private String information;
    private Date voteDate;
    private Integer keepTime;
    private Integer isOver;
    private Integer participant;
    private Integer optionsNumber;

    public Vote() {
    }

    public Vote(Integer id, String voteName, String information, Date voteDate, Integer keepTime, Integer isOver, Integer participant, Integer optionsNumber) {
        this.id = id;
        this.voteName = voteName;
        this.information = information;
        this.voteDate = voteDate;
        this.keepTime = keepTime;
        this.isOver = isOver;
        this.participant = participant;
        this.optionsNumber = optionsNumber;
    }

    public Vote(String voteName, String information, Date voteDate, Integer keepTime, Integer isOver, Integer participant, Integer optionsNumber) {
        this.voteName = voteName;
        this.information = information;
        this.voteDate = voteDate;
        this.keepTime = keepTime;
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
                ", keepTime=" + keepTime +
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

    public Integer getKeepTime() {
        return keepTime;
    }

    public void setKeepTime(Integer keepTime) {
        this.keepTime = keepTime;
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
