package com.classmanagement.service.impl;

import com.classmanagement.dao.ExaminationMapper;
import com.classmanagement.entity.Examination;
import com.classmanagement.service.ExaminationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExaminationServiceImpl implements ExaminationService {

    final ExaminationMapper examinationMapper;

    public ExaminationServiceImpl(ExaminationMapper examinationMapper) {
        this.examinationMapper = examinationMapper;
    }

    @Override
    public Integer insertExamination(Examination examination) {
        return examinationMapper.insertExamination(examination);
    }

    @Override
    public Examination queryExaminationById(Integer id) {
        return examinationMapper.queryExaminationById(id);
    }

    @Override
    public Integer updateExamination(Examination examination) {
        return examinationMapper.updateExamination(examination);
    }

    @Override
    public Integer deleteExaminationById(Integer id) {
        return examinationMapper.deleteExaminationById(id);
    }

    @Override
    public List<Examination> queryExaminationLimitIn10(Integer page) {
        return examinationMapper.queryExaminationLimit((page - 1) * 10, 10);
    }
}
