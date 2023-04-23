package com.classmanagement.entity;

import java.util.List;

public class VoteWithOptionsAndComments {

    private Vote vote;
    private List<VoteOption> options;
    private List<VoteComment> comments;

    @Override
    public String toString() {
        return "VoteWithOptionsAndComments{" +
                "vote=" + vote +
                ", options=" + options +
                ", comments=" + comments +
                '}';
    }

    public Vote getVote() {
        return vote;
    }

    public void setVote(Vote vote) {
        this.vote = vote;
    }

    public List<VoteOption> getOptions() {
        return options;
    }

    public void setOptions(List<VoteOption> options) {
        this.options = options;
    }

    public List<VoteComment> getComments() {
        return comments;
    }

    public void setComments(List<VoteComment> comments) {
        this.comments = comments;
    }

    public VoteWithOptionsAndComments() {
    }

    public VoteWithOptionsAndComments(Vote vote, List<VoteOption> options, List<VoteComment> comments) {
        this.vote = vote;
        this.options = options;
        this.comments = comments;
    }
}
