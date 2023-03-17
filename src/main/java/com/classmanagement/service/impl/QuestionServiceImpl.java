package com.classmanagement.service.impl;

import com.classmanagement.dao.QuestionMapper;
import com.classmanagement.entity.Question;
import com.classmanagement.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    final QuestionMapper questionMapper;

    public QuestionServiceImpl(QuestionMapper questionMapper) {
        this.questionMapper = questionMapper;
    }


    @Override
    public Integer insertQuestion(Question question) {
        return questionMapper.insertQuestion(question);
    }

    @Override
    public List<Question> queryQuestionsByQuestionnaireId(Integer questionnaireId) {
        return questionMapper.queryQuestionsByQuestionnaireId(questionnaireId);
    }

    @Override
    public Integer updateQuestion(Question question) {
        return questionMapper.updateQuestion(question);
    }

    @Override
    public Integer deleteQuestionById(Integer id) {
        return questionMapper.deleteQuestionById(id);
    }
}
