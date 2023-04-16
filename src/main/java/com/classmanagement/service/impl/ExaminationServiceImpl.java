package com.classmanagement.service.impl;

import com.classmanagement.dao.ExaminationMapper;
import com.classmanagement.dao.ScoreMapper;
import com.classmanagement.entity.Examination;
import com.classmanagement.entity.ExaminationWithScoresVO;
import com.classmanagement.entity.Score;
import com.classmanagement.service.ExaminationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ExaminationServiceImpl implements ExaminationService {

    final ExaminationMapper examinationMapper;
    final ScoreMapper scoreMapper;

    public ExaminationServiceImpl(ExaminationMapper examinationMapper, ScoreMapper scoreMapper) {
        this.examinationMapper = examinationMapper;
        this.scoreMapper = scoreMapper;
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

    @Override
    public Integer queryExaminationsCount() {
        return examinationMapper.queryExaminationsCount();
    }

    @Transactional
    @Override
    public Integer addExaminationWithScores(ExaminationWithScoresVO examination) {
        examinationMapper.insertExamination(examination.getExamination());
        Integer id = examination.getExamination().getId();
        if (id != null) {
            for (Score score : examination.getScores()) {
                if (score != null) {
                    score.setExaminationId(id);
                }
            }
            Integer insertScores = scoreMapper.insertScores(examination.getScores());
            if (insertScores != 0) return 1;
        }
        return 0;
    }
}
