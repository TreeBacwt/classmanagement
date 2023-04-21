package com.classmanagement.service.impl;

import com.classmanagement.dao.ParentQuestionnaireMapper;
import com.classmanagement.entity.ParentQuestionnaire;
import com.classmanagement.service.ParentQuestionnaireService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentQuestionnaireServiceImpl implements ParentQuestionnaireService {

    final ParentQuestionnaireMapper parentQuestionnaireMapper;

    public ParentQuestionnaireServiceImpl(ParentQuestionnaireMapper parentQuestionnaireMapper) {
        this.parentQuestionnaireMapper = parentQuestionnaireMapper;
    }

    @Override
    public Integer insertParentQuestionnaire(ParentQuestionnaire parentQuestionnaire) {
        return parentQuestionnaireMapper.insertParentQuestionnaire(parentQuestionnaire);
    }

    @Override
    public Integer deleteParentQuestionnaireByParentIdAndQuestionnaireId(Integer pid, Integer qid) {
        return parentQuestionnaireMapper.deleteParentQuestionnaireByParentIdAndQuestionnaireId(pid, qid);
    }

    @Override
    public List<ParentQuestionnaire> queryParentQuestionnaireByParentId(Integer pid) {
        return parentQuestionnaireMapper.queryParentQuestionnaireByParentId(pid);
    }

    @Override
    public List<ParentQuestionnaire> queryParentQuestionnaireByParentIdLimitIn10(Integer pid, Integer page) {
        return parentQuestionnaireMapper.queryParentQuestionnaireByParentIdLimit(pid, (page - 1) * 10, 10);
    }
}
