package com.classmanagement.entity;

public class VoteOption {

    private Integer id;
    private String content;
    private Integer number;
    private Integer voteId;

    public VoteOption() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getVoteId() {
        return voteId;
    }

    public void setVoteId(Integer voteId) {
        this.voteId = voteId;
    }

    @Override
    public String toString() {
        return "VoteOption{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", number=" + number +
                ", voteId=" + voteId +
                '}';
    }

    public VoteOption(String content, Integer number, Integer voteId) {
        this.content = content;
        this.number = number;
        this.voteId = voteId;
    }

    public VoteOption(Integer id, String content, Integer number, Integer voteId) {
        this.id = id;
        this.content = content;
        this.number = number;
        this.voteId = voteId;
    }
}
