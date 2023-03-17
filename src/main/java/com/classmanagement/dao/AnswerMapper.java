package com.classmanagement.dao;

import com.classmanagement.entity.Answer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AnswerMapper {

    Integer insertAnswer(Answer answer);
    List<Answer> queryAnswerByQuestionId(Integer questionId);

}
