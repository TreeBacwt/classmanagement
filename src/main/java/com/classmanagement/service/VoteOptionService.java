package com.classmanagement.service;

import com.classmanagement.entity.VoteOption;

import java.util.List;

public interface VoteOptionService {

    Integer insertVoteOption(VoteOption voteOption);

    VoteOption queryVoteOptionById(Integer id);

    Integer updateVoteOption(VoteOption voteOption);

    Integer deleteVoteOptionById(Integer id);

    List<VoteOption> queryVoteOptionsByVoteIdLimitIn10(Integer voteId, Integer page);

    List<VoteOption> queryVoteOptionsByVoteId(Integer voteId);

}
