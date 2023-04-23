package com.classmanagement.dao;

import com.classmanagement.entity.StudentVote;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentVoteMapper {

    Integer insertStudentVote(StudentVote studentVote);

    List<StudentVote> queryStudentVotesByVoteOptionId(Integer voteOptionId);

    Integer deleteStudentVoteByStudentNumAndVoteOptionId(Integer studentNum, Integer voteOptionId);

    List<StudentVote> queryStudentVotesByStudentNum(Integer studentNum);

    Integer deleteStudentVoteByVoteOptionId(Integer voteOptionId);
}
