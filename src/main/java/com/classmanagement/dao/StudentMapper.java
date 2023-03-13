package com.classmanagement.dao;

import com.classmanagement.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {

    Integer insertStudent(Student student);
    Student queryStudentByStudentNum(Integer studentNum);
    Integer updateStudent(Student student);
    Integer deleteStudentByStudentNum(Integer studentNum);
    List<Student> queryStudentsLimit(Integer start, Integer limit);
}
