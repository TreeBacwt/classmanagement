package com.classmanagement.dao;

import com.classmanagement.entity.Examination;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ExaminationMapper {

    Integer insertExamination(Examination examination);
    Examination queryExaminationById(Integer id);
    Integer updateExamination(Examination examination);
    Integer deleteExaminationById(Integer id);

}
