package com.classmanagement.dao;

import com.classmanagement.entity.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper {

    public Integer insertStudent(Student student);
    public Student queryStudentByStudentNum(Integer studentNum);
    public Integer updateStudent(Student student);
    public Integer deleteStudentByStudentNum(Integer studentNum);
}
