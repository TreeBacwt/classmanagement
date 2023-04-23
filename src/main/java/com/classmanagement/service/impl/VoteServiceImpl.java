package com.classmanagement.service.impl;

import com.classmanagement.dao.VoteCommentMapper;
import com.classmanagement.dao.VoteMapper;
import com.classmanagement.dao.VoteOptionMapper;
import com.classmanagement.entity.*;
import com.classmanagement.service.VoteService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class VoteServiceImpl implements VoteService {

    final VoteMapper voteMapper;
    final VoteOptionMapper voteOptionMapper;
    final VoteCommentMapper voteCommentMapper;

    public VoteServiceImpl(VoteMapper voteMapper, VoteOptionMapper voteOptionMapper, VoteCommentMapper voteCommentMapper) {
        this.voteMapper = voteMapper;
        this.voteOptionMapper = voteOptionMapper;
        this.voteCommentMapper = voteCommentMapper;
    }

    @Override
    public Integer insertVote(Vote vote) {
        return voteMapper.insertVote(vote);
    }

    @Override
    @Transactional
    public Vote queryVoteById(Integer id) {
        Vote vote = voteMapper.queryVoteById(id);
        Integer voteIsOver = voteIsOver(vote);
        if (voteIsOver != 0) {
            return vote;
        } else return null;
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
    @Transactional
    public List<Vote> queryVotesLimitIn10(Integer page) {
        List<Vote> votes = voteMapper.queryVotesLimit((page - 1) * 10, 10);
        int result = 1;
        for (Vote vote : votes) {
            result *= voteIsOver(vote);
        }
        if (result == 1)
            return votes;
        else return null;
    }

    @Override
    @Transactional
    public Integer insertVoteWithOptions(VoteWithOptionsVO voteWithOptionsVO) {
        Vote vote = voteWithOptionsVO.getVote();
        Integer insertVote = voteMapper.insertVote(vote);
        if (insertVote != 0) {
            Integer voteId = vote.getId();
            List<VoteOption> options = voteWithOptionsVO.getOptions();
            int result = 1;
            for (VoteOption voteOption : options) {
                voteOption.setVoteId(voteId);
                result *= voteOptionMapper.insertVoteOption(voteOption);
            }
            return result;
        } else return 0;
    }

    @Override
    public Integer getTotal() {
        return voteMapper.getTotal();
    }

    @Override
    @Transactional
    public VoteWithOptionsVO queryVoteWithOptionsByVoteId(Integer vid) {
        Vote vote = voteMapper.queryVoteById(vid);
        if (vote != null) {
            if (voteIsOver(vote) != 0) {
                List<VoteOption> voteOptions = voteOptionMapper.queryVoteOptionsByVoteId(vid);
                if (voteOptions.size() != 0) {
                    return new VoteWithOptionsVO(vote, voteOptions);
                }
            }
        }
        return null;
    }

    private Integer voteIsOver(Vote vote) {
        if (vote.getIsOver() == 0) {
            Date nowTime = new Date();
            if (nowTime.compareTo(vote.getOverDate()) > 0) {
                vote.setIsOver(1);
                return voteMapper.updateVote(vote);
            }
        }
        return 1;
    }
}
