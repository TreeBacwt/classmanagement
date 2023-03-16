package com.classmanagement.entity;

public class StudentVote {

    private Integer studentNum;
    private Integer voteOptionId;

    public Integer getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(Integer studentNum) {
        this.studentNum = studentNum;
    }

    public Integer getVoteOptionId() {
        return voteOptionId;
    }

    public void setVoteOptionId(Integer voteOptionId) {
        this.voteOptionId = voteOptionId;
    }

    @Override
    public String toString() {
        return "StudentVote{" +
                "studentNum=" + studentNum +
                ", voteOptionId=" + voteOptionId +
                '}';
    }

    public StudentVote(Integer studentNum, Integer voteOptionId) {
        this.studentNum = studentNum;
        this.voteOptionId = voteOptionId;
    }

    public StudentVote() {
    }
}
