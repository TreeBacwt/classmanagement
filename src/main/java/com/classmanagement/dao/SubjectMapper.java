package com.classmanagement.dao;

import com.classmanagement.entity.Subject;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SubjectMapper {

    Integer insertSubject(Subject subject);

    Subject querySubjectById(Integer id);

    Integer updateSubject(Subject subject);

    Integer deleteSubjectById(Integer id);

    List<Subject> querySubjectsLimit(Integer start, Integer limit);

    Integer insertSubjects(List<Subject> subjects);

    List<Subject> queryAllSubjects();

}
