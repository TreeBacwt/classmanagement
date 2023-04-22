package com.classmanagement.service.impl;

import com.classmanagement.dao.AnswerMapper;
import com.classmanagement.entity.*;
import com.classmanagement.service.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    final AnswerMapper answerMapper;
    final ParentQuestionnaireService parentQuestionnaireService;
    final QuestionService questionService;
    final QuestionnaireService questionnaireService;
    final QuestionOptionService questionOptionService;
    final ParentService parentService;

    public AnswerServiceImpl(AnswerMapper answerMapper, ParentQuestionnaireService parentQuestionnaireService, QuestionService questionService, QuestionnaireService questionnaireService, QuestionOptionService questionOptionService, ParentService parentService) {
        this.answerMapper = answerMapper;
        this.parentQuestionnaireService = parentQuestionnaireService;
        this.questionService = questionService;
        this.questionnaireService = questionnaireService;
        this.questionOptionService = questionOptionService;
        this.parentService = parentService;
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

    @Override
    public HashMap<String, List<String>> queryAnswersSituationByQuestionId(Integer questionId) {
        HashMap<String, List<String>> answersSituations = new HashMap<>();

        List<QuestionOption> questionOptions = questionOptionService.queryQuestionOptionByQuestionId(questionId);
        for (QuestionOption questionOption : questionOptions) {
            Integer questionOptionId = questionOption.getId();
            List<Answer> answers = answerMapper.queryAnswersByQuestionOptionId(questionOptionId);
            //遍历answers，读取并存储选择该选项的家长
            List<String> parentsOfOption = new ArrayList<>();
            for (Answer answer : answers) {
                Parent parent = parentService.queryParentById(answer.getParentId());
                if (parent != null)
                    parentsOfOption.add(parent.getParentName());
            }
            answersSituations.put(questionOption.getContent(), parentsOfOption);
        }
        return answersSituations;
    }
}
