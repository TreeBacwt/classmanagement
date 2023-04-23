package com.classmanagement.service.impl;

import com.classmanagement.dao.StudentVoteMapper;
import com.classmanagement.dao.VoteMapper;
import com.classmanagement.dao.VoteOptionMapper;
import com.classmanagement.entity.StudentVote;
import com.classmanagement.entity.Vote;
import com.classmanagement.entity.VoteOption;
import com.classmanagement.service.StudentVoteService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentVoteServiceImpl implements StudentVoteService {

    final StudentVoteMapper studentVoteMapper;
    final VoteOptionMapper voteOptionMapper;
    final VoteMapper voteMapper;

    public StudentVoteServiceImpl(StudentVoteMapper studentVoteMapper, VoteOptionMapper voteOptionMapper, VoteMapper voteMapper) {
        this.studentVoteMapper = studentVoteMapper;
        this.voteOptionMapper = voteOptionMapper;
        this.voteMapper = voteMapper;
    }

    @Override
    public Integer insertStudentVote(StudentVote studentVote) {
        return studentVoteMapper.insertStudentVote(studentVote);
    }

    @Override
    public List<StudentVote> queryStudentVotesByVoteOptionId(Integer voteOptionId) {
        return studentVoteMapper.queryStudentVotesByVoteOptionId(voteOptionId);
    }

    @Override
    public Integer deleteStudentVoteByStudentNumAndVoteOptionId(Integer studentNum, Integer voteOptionId) {
        return studentVoteMapper.deleteStudentVoteByStudentNumAndVoteOptionId(studentNum, voteOptionId);
    }

    @Override
    @Transactional
    public Integer insertStudentVotes(List<StudentVote> studentVotes) {
        int result = 1;
        if (studentVotes.size() != 0) {
            Integer voteOptionId = studentVotes.get(0).getVoteOptionId();
            Integer voteId = voteOptionMapper.queryVoteOptionById(voteOptionId).getVoteId();
            Vote vote = voteMapper.queryVoteById(voteId);
            vote.setParticipant(vote.getParticipant() + 1);
            result *= voteMapper.updateVote(vote);
        }
        for (StudentVote studentVote : studentVotes) {
            result *= studentVoteMapper.insertStudentVote(studentVote);
        }
        return result;
    }

    @Override
    public Integer QueryIsStudentVotedByStudentNum(Integer studentNum, Integer vid) {
        List<StudentVote> studentVotes = studentVoteMapper.queryStudentVotesByStudentNum(studentNum);
        List<VoteOption> voteOptions = voteOptionMapper.queryVoteOptionsByVoteId(vid);
        for (StudentVote studentVote : studentVotes) {
            Integer voteOptionId = studentVote.getVoteOptionId();
            for (VoteOption voteOption : voteOptions) {
                if (voteOption.getId() == voteOptionId) return 1;
            }
        }
        return 0;
    }
}
