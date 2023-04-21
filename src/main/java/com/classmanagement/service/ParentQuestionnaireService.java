package com.classmanagement.service;

import com.classmanagement.entity.ParentQuestionnaire;

import java.util.List;

public interface ParentQuestionnaireService {

    Integer insertParentQuestionnaire(ParentQuestionnaire parentQuestionnaire);

    Integer deleteParentQuestionnaireByParentIdAndQuestionnaireId(Integer pid, Integer qid);

    List<ParentQuestionnaire> queryParentQuestionnaireByParentId(Integer pid);

    List<ParentQuestionnaire> queryParentQuestionnaireByParentIdLimitIn10(Integer pid, Integer page);
}
