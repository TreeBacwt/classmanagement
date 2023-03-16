package com.classmanagement.service.impl;

import com.classmanagement.dao.StudentVoteMapper;
import com.classmanagement.entity.StudentVote;
import com.classmanagement.service.StudentVoteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentVoteServiceImpl implements StudentVoteService {

    final StudentVoteMapper studentVoteMapper;

    public StudentVoteServiceImpl(StudentVoteMapper studentVoteMapper) {
        this.studentVoteMapper = studentVoteMapper;
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
}
