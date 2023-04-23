package com.classmanagement.service;

import com.classmanagement.entity.StudentVote;

import java.util.HashMap;
import java.util.List;

public interface StudentVoteService {

    Integer insertStudentVote(StudentVote studentVote);

    List<StudentVote> queryStudentVotesByVoteOptionId(Integer voteOptionId);

    Integer deleteStudentVoteByStudentNumAndVoteOptionId(Integer studentNum, Integer voteOptionId);

    Integer insertStudentVotes(List<StudentVote> studentVotes);

    Integer QueryIsStudentVotedByStudentNum(Integer studentNum, Integer vid);
}
