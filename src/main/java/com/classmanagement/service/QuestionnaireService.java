package com.classmanagement.service;

import com.classmanagement.entity.Questionnaire;
import com.classmanagement.entity.QuestionnaireWithQuestionsAndOptionsVO;

import java.util.List;

public interface QuestionnaireService {

    Integer insertQuestionnaire(Questionnaire questionnaire);

    Questionnaire queryQuestionnaireById(Integer id);

    Integer updateQuestionnaire(Questionnaire questionnaire);

    Integer deleteQuestionnaireById(Integer id);

    List<Questionnaire> queryQuestionnairesLimitIn10(Integer page);

    Integer addQuestionnaireWithQuestionsAndOptions(QuestionnaireWithQuestionsAndOptionsVO questionnaireWithQuestionsAndOptionsVO);

    QuestionnaireWithQuestionsAndOptionsVO queryQuestionnaireWithQuestionsAndOptionsById(Integer id);

    List<Questionnaire> queryAllQuestionnaires();

    Integer getTotal();

}
