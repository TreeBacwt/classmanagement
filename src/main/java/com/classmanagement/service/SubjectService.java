package com.classmanagement.service;

import com.classmanagement.entity.Subject;

import java.util.List;

public interface SubjectService {

    Integer insertSubject(Subject subject);
    Subject querySubjectById(Integer id);
    Integer updateSubject(Subject subject);
    Integer deleteSubjectById(Integer id);
    List<Subject> querySubjectsLimitIn10(Integer page);
    Integer insertSubjects(List<Subject> subjects);
}
