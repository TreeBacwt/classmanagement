package com.classmanagement.dao;

import com.classmanagement.entity.VoteComment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VoteCommentMapper {

    Integer insertVoteComment(VoteComment voteComment);

    Integer deleteVoteCommentByStudentNumAndVoteId(Integer studentNum, Integer voteId);

    List<VoteComment> queryAllVoteCommentsByVoteId(Integer vid);

    Integer deleteVoteCommentById(Integer id);

    Integer deleteVoteCommentByVoteId(Integer vid);
}
