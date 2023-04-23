package com.classmanagement.service;

import com.classmanagement.entity.Vote;
import com.classmanagement.entity.VoteWithOptions;

import java.util.List;

public interface VoteService {

    Integer insertVote(Vote vote);

    Vote queryVoteById(Integer id);

    Integer updateVote(Vote vote);

    Integer deleteVoteById(Integer id);

    List<Vote> queryVotesLimitIn10(Integer page);

    Integer insertVoteWithOptions(VoteWithOptions voteWithOptions);

}
