package com.classmanagement.dao;

import com.classmanagement.entity.QuestionOption;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuestionOptionMapper {

    Integer insertQuestionOption(QuestionOption questionOption);
    List<QuestionOption> queryQuestionOptionByQuestionId(Integer questionId);
    Integer updateQuestionOption(QuestionOption questionOption);
    Integer deleteQuestionOptionById(Integer id);

}
