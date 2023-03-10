package com.classmanagement.service;

import com.classmanagement.entity.Student;
import com.classmanagement.entity.User;

public interface StudentService {

    /*返回userId*/
    public Integer addStudent(User user, Student student);
    public Integer deleteStudentByStudentNum(Integer studentNum);
    public Integer updateStudent(Student student);
    public Student queryStudentByStudentNum(Integer studentNum);

}
