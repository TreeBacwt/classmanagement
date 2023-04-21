package com.classmanagement.dao;

import com.classmanagement.entity.ParentQuestionnaire;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ParentQuestionnaireMapper {

    Integer insertParentQuestionnaire(ParentQuestionnaire parentQuestionnaire);

    Integer deleteParentQuestionnaireByParentIdAndQuestionnaireId(Integer pid, Integer qid);

    List<ParentQuestionnaire> queryParentQuestionnaireByParentId(Integer pid);

    List<ParentQuestionnaire> queryParentQuestionnaireByParentIdLimit(Integer pid, Integer start, Integer limit);

    Integer updateParentQuestionnaire(ParentQuestionnaire parentQuestionnaire);
}
