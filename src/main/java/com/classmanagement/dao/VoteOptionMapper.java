package com.classmanagement.dao;

import com.classmanagement.entity.VoteOption;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VoteOptionMapper {

    Integer insertVoteOption(VoteOption voteOption);

    VoteOption queryVoteOptionById(Integer id);

    Integer updateVoteOption(VoteOption voteOption);

    Integer deleteVoteOptionById(Integer id);

    List<VoteOption> queryVoteOptionsByVoteIdLimit(Integer voteId, Integer start, Integer limit);

    List<VoteOption> queryVoteOptionsByVoteId(Integer voteId);

}
