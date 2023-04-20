package com.classmanagement.service.impl;

import com.classmanagement.dao.QuestionMapper;
import com.classmanagement.dao.QuestionOptionMapper;
import com.classmanagement.dao.QuestionnaireMapper;
import com.classmanagement.entity.*;
import com.classmanagement.service.QuestionnaireService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {

    final QuestionnaireMapper questionnaireMapper;
    final QuestionMapper questionMapper;
    final QuestionOptionMapper questionOptionMapper;

    public QuestionnaireServiceImpl(QuestionnaireMapper questionnaireMapper, QuestionMapper questionMapper, QuestionOptionMapper questionOptionMapper) {
        this.questionnaireMapper = questionnaireMapper;
        this.questionMapper = questionMapper;
        this.questionOptionMapper = questionOptionMapper;
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

    @Transactional
    @Override
    public Integer addQuestionnaireWithQuestionsAndOptions(QuestionnaireWithQuestionsAndOptionsVO questionnaireWithQuestionsAndOptionsVO) {
        Questionnaire questionnaire = questionnaireWithQuestionsAndOptionsVO.getQuestionnaire();
        int result = 1;
        if (insertQuestionnaire(questionnaire) != 0) {
            //调查问卷表插入成功
            Integer questionnaireId = questionnaire.getId();
            List<QuestionWithOptionsVO> questionWithOptionsVOS = questionnaireWithQuestionsAndOptionsVO.getQuestions();
            for (QuestionWithOptionsVO questionWithOptionsVO : questionWithOptionsVOS) {
                //遍历QuestionList
                Question question = questionWithOptionsVO.getQuestion();
                question.setQuestionnaireId(questionnaireId);
                if (questionMapper.insertQuestion(question) != 0) {
                    //Question插入成功
                    Integer questionId = question.getId();
                    List<QuestionOption> options = questionWithOptionsVO.getOptions();
                    for (QuestionOption questionOption : options) {
                        //循环插入option
                        questionOption.setQuestionId(questionId);
                        if (questionOptionMapper.insertQuestionOption(questionOption) == 0) {
                            result = 0;
                        }
                    }
                } else result = 0;
            }
        } else result = 0;
        return result;
    }

}
