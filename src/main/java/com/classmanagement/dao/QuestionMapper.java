package com.classmanagement.dao;

import com.classmanagement.entity.Question;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuestionMapper {

    Integer insertQuestion(Question question);
    List<Question> queryQuestionsByQuestionnaireId(Integer questionnaireId);
    Integer updateQuestion(Question question);
    Integer deleteQuestionById(Integer id);

}
