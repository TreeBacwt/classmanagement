package com.classmanagement.service;

import com.classmanagement.entity.StudentVote;

import java.util.List;

public interface StudentVoteService {

    Integer insertStudentVote(StudentVote studentVote);
    List<StudentVote> queryStudentVotesByVoteOptionId(Integer voteOptionId);
    Integer deleteStudentVoteByStudentNumAndVoteOptionId(Integer studentNum, Integer voteOptionId);

}
