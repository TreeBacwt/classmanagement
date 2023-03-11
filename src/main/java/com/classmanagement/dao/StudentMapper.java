package com.classmanagement.dao;

import com.classmanagement.entity.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper {

    Integer insertStudent(Student student);
    Student queryStudentByStudentNum(Integer studentNum);
    Integer updateStudent(Student student);
    Integer deleteStudentByStudentNum(Integer studentNum);
}
