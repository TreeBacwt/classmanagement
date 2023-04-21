package com.classmanagement.dao;

import com.classmanagement.entity.Questionnaire;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuestionnaireMapper {

    Integer insertQuestionnaire(Questionnaire questionnaire);

    Questionnaire queryQuestionnaireById(Integer id);

    Integer updateQuestionnaire(Questionnaire questionnaire);

    Integer deleteQuestionnaireById(Integer id);

    List<Questionnaire> queryQuestionnairesLimit(Integer start, Integer limit);

    List<Questionnaire> queryAllQuestionnaires();

    Integer getTotal();
}
