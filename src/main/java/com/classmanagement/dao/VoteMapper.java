package com.classmanagement.dao;

import com.classmanagement.entity.Vote;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VoteMapper {

    Integer insertVote(Vote vote);

    Vote queryVoteById(Integer id);

    Integer updateVote(Vote vote);

    Integer deleteVoteById(Integer id);

    List<Vote> queryVotesLimit(Integer start, Integer limit);

    Integer getTotal();

}
