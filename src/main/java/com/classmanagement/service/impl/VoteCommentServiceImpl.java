package com.classmanagement.service.impl;

import com.classmanagement.dao.VoteCommentMapper;
import com.classmanagement.entity.VoteComment;
import com.classmanagement.service.VoteCommentService;

import java.util.List;

public class VoteCommentServiceImpl implements VoteCommentService {

    final VoteCommentMapper voteCommentMapper;

    public VoteCommentServiceImpl(VoteCommentMapper voteCommentMapper) {
        this.voteCommentMapper = voteCommentMapper;
    }

    @Override
    public Integer insertVoteComment(VoteComment voteComment) {
        return voteCommentMapper.insertVoteComment(voteComment);
    }

    @Override
    public Integer deleteVoteCommentByStudentNumAndVoteId(Integer studentNum, Integer voteId) {
        return voteCommentMapper.deleteVoteCommentByStudentNumAndVoteId(studentNum, voteId);
    }

    @Override
    public List<VoteComment> queryAllVoteCommentsByVoteId(Integer vid) {
        return voteCommentMapper.queryAllVoteCommentsByVoteId(vid);
    }
}
