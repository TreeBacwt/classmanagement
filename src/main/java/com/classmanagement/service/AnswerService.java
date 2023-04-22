package com.classmanagement.service;

import com.classmanagement.entity.Answer;

import java.util.HashMap;
import java.util.List;

public interface AnswerService {

    Integer insertAnswer(Answer answer);

    List<Answer> queryAnswerByQuestionId(Integer questionId);

    Integer insertAnswers(List<Answer> answers);

    HashMap<String, List<String>> queryAnswersSituationByQuestionId(Integer questionId);
}
