package com.classmanagement.service;

import com.classmanagement.entity.Examination;
import com.classmanagement.entity.ExaminationWithScoresVO;

import java.util.List;

public interface ExaminationService {

    Integer insertExamination(Examination examination);

    Examination queryExaminationById(Integer id);

    Integer updateExamination(Examination examination);

    Integer deleteExaminationById(Integer id);

    List<Examination> queryExaminationLimitIn10(Integer page);

    Integer queryExaminationsCount();

    Integer addExaminationWithScores(ExaminationWithScoresVO examination);

}
