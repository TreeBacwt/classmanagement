package com.classmanagement.service.impl;

import com.classmanagement.dao.VoteOptionMapper;
import com.classmanagement.entity.VoteOption;
import com.classmanagement.service.VoteOptionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteOptionServiceImpl implements VoteOptionService {

    final VoteOptionMapper voteOptionMapper;

    public VoteOptionServiceImpl(VoteOptionMapper voteOptionMapper) {
        this.voteOptionMapper = voteOptionMapper;
    }

    @Override
    public Integer insertVoteOption(VoteOption voteOption) {
        return voteOptionMapper.insertVoteOption(voteOption);
    }

    @Override
    public VoteOption queryVoteOptionById(Integer id) {
        return voteOptionMapper.queryVoteOptionById(id);
    }

    @Override
    public Integer updateVoteOption(VoteOption voteOption) {
        return voteOptionMapper.updateVoteOption(voteOption);
    }

    @Override
    public Integer deleteVoteOptionById(Integer id) {
        return voteOptionMapper.deleteVoteOptionById(id);
    }

    @Override
    public List<VoteOption> queryVoteOptionsByVoteIdLimitIn10(Integer voteId, Integer page) {
        return voteOptionMapper.queryVoteOptionsByVoteIdLimit(voteId, (page - 1) * 10, 10);
    }

    @Override
    public List<VoteOption> queryVoteOptionsByVoteId(Integer voteId) {
        return voteOptionMapper.queryVoteOptionsByVoteId(voteId);
    }
}
