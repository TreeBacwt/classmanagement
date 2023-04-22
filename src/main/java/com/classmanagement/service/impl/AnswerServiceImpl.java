package com.classmanagement.service.impl;

import com.classmanagement.dao.AnswerMapper;
import com.classmanagement.entity.Answer;
import com.classmanagement.entity.ParentQuestionnaire;
import com.classmanagement.entity.Questionnaire;
import com.classmanagement.service.AnswerService;
import com.classmanagement.service.ParentQuestionnaireService;
import com.classmanagement.service.QuestionService;
import com.classmanagement.service.QuestionnaireService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    final AnswerMapper answerMapper;
    final ParentQuestionnaireService parentQuestionnaireService;
    final QuestionService questionService;
    final QuestionnaireService questionnaireService;

    public AnswerServiceImpl(AnswerMapper answerMapper, ParentQuestionnaireService parentQuestionnaireService, QuestionService questionService, QuestionnaireService questionnaireService) {
        this.answerMapper = answerMapper;
        this.parentQuestionnaireService = parentQuestionnaireService;
        this.questionService = questionService;
        this.questionnaireService = questionnaireService;
    }

    @Override
    public Integer insertAnswer(Answer answer) {
        return answerMapper.insertAnswer(answer);
    }

    @Override
    public List<Answer> queryAnswerByQuestionId(Integer questionId) {
        return answerMapper.queryAnswerByQuestionId(questionId);
    }

    @Override
    @Transactional
    public Integer insertAnswers(List<Answer> answers) {
        int result = 1;
        for (Answer answer : answers) {
            result *= answerMapper.insertAnswer(answer);
        }

        if (result == 1) {
            //添加完成记录
            Integer questionId = answers.get(0).getQuestionId();
            Integer parentId = answers.get(0).getParentId();
            Integer questionnaireId = questionService.queryQuestionById(questionId).getQuestionnaireId();
            result *= parentQuestionnaireService.insertParentQuestionnaire(new ParentQuestionnaire(parentId, questionnaireId, 1));
            //问卷完成数量+1
            Questionnaire questionnaire = questionnaireService.queryQuestionnaireById(questionnaireId);
            questionnaire.setRespondent(questionnaire.getRespondent() + 1);
            result *= questionnaireService.updateQuestionnaire(questionnaire);
        }
        return result;
    }
}
