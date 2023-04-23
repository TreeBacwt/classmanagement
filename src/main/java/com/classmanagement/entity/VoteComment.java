package com.classmanagement.entity;

import java.util.Date;

public class VoteComment {

    private Integer studentNum;
    private Integer voteId;
    private String comment;
    private Date commentDate;

    public VoteComment(Integer studentNum, Integer voteId, String comment, Date commentDate) {
        this.studentNum = studentNum;
        this.voteId = voteId;
        this.comment = comment;
        this.commentDate = commentDate;
    }

    @Override
    public String toString() {
        return "VoteComment{" +
                "studentNum=" + studentNum +
                ", voteId=" + voteId +
                ", comment='" + comment + '\'' +
                ", commentDate=" + commentDate +
                '}';
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public Integer getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(Integer studentNum) {
        this.studentNum = studentNum;
    }

    public Integer getVoteId() {
        return voteId;
    }

    public void setVoteId(Integer voteId) {
        this.voteId = voteId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public VoteComment() {
    }

    public VoteComment(Integer studentNum, Integer voteId, String comment) {
        this.studentNum = studentNum;
        this.voteId = voteId;
        this.comment = comment;
    }
}
