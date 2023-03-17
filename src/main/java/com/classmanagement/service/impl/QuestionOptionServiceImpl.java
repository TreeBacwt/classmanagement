package com.classmanagement.service.impl;

import com.classmanagement.dao.QuestionOptionMapper;
import com.classmanagement.entity.QuestionOption;
import com.classmanagement.service.QuestionOptionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionOptionServiceImpl implements QuestionOptionService {

    final QuestionOptionMapper questionOptionMapper;

    public QuestionOptionServiceImpl(QuestionOptionMapper questionOptionMapper) {
        this.questionOptionMapper = questionOptionMapper;
    }

    @Override
    public Integer insertQuestionOption(QuestionOption questionOption) {
        return questionOptionMapper.insertQuestionOption(questionOption);
    }

    @Override
    public List<QuestionOption> queryQuestionOptionByQuestionId(Integer questionId) {
        return questionOptionMapper.queryQuestionOptionByQuestionId(questionId);
    }

    @Override
    public Integer updateQuestionOption(QuestionOption questionOption) {
        return questionOptionMapper.updateQuestionOption(questionOption);
    }

    @Override
    public Integer deleteQuestionOptionById(Integer id) {
        return questionOptionMapper.deleteQuestionOptionById(id);
    }
}
