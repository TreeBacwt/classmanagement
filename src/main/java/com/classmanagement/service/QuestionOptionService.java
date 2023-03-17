package com.classmanagement.service;

import com.classmanagement.entity.QuestionOption;

import java.util.List;

public interface QuestionOptionService {

    Integer insertQuestionOption(QuestionOption questionOption);
    List<QuestionOption> queryQuestionOptionByQuestionId(Integer questionId);
    Integer updateQuestionOption(QuestionOption questionOption);
    Integer deleteQuestionOptionById(Integer id);

}
