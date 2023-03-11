package com.classmanagement.service;

import com.classmanagement.entity.Student;
import com.classmanagement.entity.User;

public interface StudentService {

    /*返回userId*/
    Integer addStudent(User user, Student student);
    Integer deleteStudentByStudentNum(Integer studentNum);
    Integer updateStudent(Student student);
    Student queryStudentByStudentNum(Integer studentNum);

}
