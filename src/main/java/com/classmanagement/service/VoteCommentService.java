package com.classmanagement.service;

import com.classmanagement.entity.VoteComment;

import java.util.List;

public interface VoteCommentService {

    Integer insertVoteComment(VoteComment voteComment);

    Integer deleteVoteCommentByStudentNumAndVoteId(Integer studentNum, Integer voteId);

    List<VoteComment> queryAllVoteCommentsByVoteId(Integer vid);
}
