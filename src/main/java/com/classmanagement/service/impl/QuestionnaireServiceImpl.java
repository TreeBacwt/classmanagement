package com.classmanagement.service.impl;

import com.classmanagement.dao.QuestionnaireMapper;
import com.classmanagement.entity.Questionnaire;
import com.classmanagement.service.QuestionnaireService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {

    final QuestionnaireMapper questionnaireMapper;

    public QuestionnaireServiceImpl(QuestionnaireMapper questionnaireMapper) {
        this.questionnaireMapper = questionnaireMapper;
    }

    @Override
    public Integer insertQuestionnaire(Questionnaire questionnaire) {
        return questionnaireMapper.insertQuestionnaire(questionnaire);
    }

    @Override
    public Questionnaire queryQuestionnaireById(Integer id) {
        return questionnaireMapper.queryQuestionnaireById(id);
    }

    @Override
    public Integer updateQuestionnaire(Questionnaire questionnaire) {
        return questionnaireMapper.updateQuestionnaire(questionnaire);
    }

    @Override
    public Integer deleteQuestionnaireById(Integer id) {
        return questionnaireMapper.deleteQuestionnaireById(id);
    }

    @Override
    public List<Questionnaire> queryQuestionnairesLimitIn10(Integer page) {
        return questionnaireMapper.queryQuestionnairesLimit((page - 1) * 10, 10);
    }

}
