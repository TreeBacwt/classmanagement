package com.classmanagement.service.impl;

import com.classmanagement.dao.SubjectMapper;
import com.classmanagement.entity.Subject;
import com.classmanagement.service.SubjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    final SubjectMapper subjectMapper;

    public SubjectServiceImpl(SubjectMapper subjectMapper) {
        this.subjectMapper = subjectMapper;
    }

    @Override
    public Integer insertSubject(Subject subject) {
        return subjectMapper.insertSubject(subject);
    }

    @Override
    public Subject querySubjectById(Integer id) {
        return subjectMapper.querySubjectById(id);
    }

    @Override
    public Integer updateSubject(Subject subject) {
        return subjectMapper.updateSubject(subject);
    }

    @Override
    public Integer deleteSubjectById(Integer id) {
        return subjectMapper.deleteSubjectById(id);
    }

    @Override
    public List<Subject> querySubjectsLimitIn10(Integer page) {
        return subjectMapper.querySubjectsLimit((page - 1) * 10, 10);
    }

    @Override
    public Integer insertSubjects(List<Subject> subjects) {
        return subjectMapper.insertSubjects(subjects);
    }

    @Override
    public List<Subject> queryAllSubjects() {
        return subjectMapper.queryAllSubjects();
    }
}
