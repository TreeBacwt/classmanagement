package com.classmanagement.entity;

public class VoteCommentWithStudentNameVo {

    private String studentName;
    private VoteComment voteComment;

    @Override
    public String toString() {
        return "VoteCommentWithStudentNameVo{" +
                "studentName='" + studentName + '\'' +
                ", voteComment=" + voteComment +
                '}';
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public VoteComment getVoteComment() {
        return voteComment;
    }

    public void setVoteComment(VoteComment voteComment) {
        this.voteComment = voteComment;
    }

    public VoteCommentWithStudentNameVo(String studentName, VoteComment voteComment) {
        this.studentName = studentName;
        this.voteComment = voteComment;
    }

    public VoteCommentWithStudentNameVo() {
    }
}
