package com.classmanagement.service.impl;

import com.classmanagement.dao.AnswerMapper;
import com.classmanagement.entity.Answer;
import com.classmanagement.service.AnswerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    final AnswerMapper answerMapper;

    public AnswerServiceImpl(AnswerMapper answerMapper) {
        this.answerMapper = answerMapper;
    }

    @Override
    public Integer insertAnswer(Answer answer) {
        return answerMapper.insertAnswer(answer);
    }

    @Override
    public List<Answer> queryAnswerByQuestionId(Integer questionId) {
        return answerMapper.queryAnswerByQuestionId(questionId);
    }
}
