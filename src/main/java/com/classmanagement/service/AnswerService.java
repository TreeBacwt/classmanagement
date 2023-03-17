package com.classmanagement.service;

import com.classmanagement.entity.Answer;

import java.util.List;

public interface AnswerService {

    Integer insertAnswer(Answer answer);
    List<Answer> queryAnswerByQuestionId(Integer questionId);

}
