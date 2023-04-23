package com.classmanagement.service;

import com.classmanagement.entity.VoteComment;
import com.classmanagement.entity.VoteCommentWithStudentNameVo;

import java.util.List;

public interface VoteCommentService {

    Integer insertVoteComment(VoteComment voteComment);

    Integer deleteVoteCommentByStudentNumAndVoteId(Integer studentNum, Integer voteId);

    List<VoteComment> queryAllVoteCommentsByVoteId(Integer vid);

    List<VoteCommentWithStudentNameVo> queryAllVoteCommentWithStudentNameVOsByVoteId(Integer vid);
}
