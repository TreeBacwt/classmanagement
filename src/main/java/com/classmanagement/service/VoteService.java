package com.classmanagement.service;

import com.classmanagement.entity.Vote;
import com.classmanagement.entity.VoteWithOptionsVO;

import java.util.HashMap;
import java.util.List;

public interface VoteService {

    Integer insertVote(Vote vote);

    Vote queryVoteById(Integer id);

    Integer updateVote(Vote vote);

    Integer deleteVoteById(Integer id);

    List<Vote> queryVotesLimitIn10(Integer page);

    Integer insertVoteWithOptions(VoteWithOptionsVO voteWithOptionsVO);

    Integer getTotal();

    VoteWithOptionsVO queryVoteWithOptionsByVoteId(Integer vid);

    HashMap<String, Float> queryStudentVotePercentageByVoteId(Integer voteId);


}
