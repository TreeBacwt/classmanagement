package com.classmanagement.service.impl;

import com.classmanagement.dao.VoteMapper;
import com.classmanagement.entity.Vote;
import com.classmanagement.service.VoteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteServiceImpl implements VoteService {

    final VoteMapper voteMapper;

    public VoteServiceImpl(VoteMapper voteMapper) {
        this.voteMapper = voteMapper;
    }

    @Override
    public Integer insertVote(Vote vote) {
        return voteMapper.insertVote(vote);
    }

    @Override
    public Vote queryVoteById(Integer id) {
        return voteMapper.queryVoteById(id);
    }

    @Override
    public Integer updateVote(Vote vote) {
        return voteMapper.updateVote(vote);
    }

    @Override
    public Integer deleteVoteById(Integer id) {
        return voteMapper.deleteVoteById(id);
    }

    @Override
    public List<Vote> queryVotesLimitIn10(Integer page) {
        return voteMapper.queryVotesLimit((page - 1) * 10, 10);
    }
}
