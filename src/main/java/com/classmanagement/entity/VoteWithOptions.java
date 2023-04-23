package com.classmanagement.entity;

import java.util.List;

public class VoteWithOptions {

    private Vote vote;
    private List<VoteOption> options;

    public VoteWithOptions(Vote vote, List<VoteOption> options) {
        this.vote = vote;
        this.options = options;
    }

    @Override
    public String toString() {
        return "VoteWithOptions{" +
                "vote=" + vote +
                ", options=" + options +
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

    public VoteWithOptions() {
    }
}
