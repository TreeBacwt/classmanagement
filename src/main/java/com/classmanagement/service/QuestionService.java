package com.classmanagement.service;

import com.classmanagement.entity.Question;

import java.util.List;

public interface QuestionService {

    Integer insertQuestion(Question question);
    List<Question> queryQuestionsByQuestionnaireId(Integer questionnaireId);
    Integer updateQuestion(Question question);
    Integer deleteQuestionById(Integer id);

}
