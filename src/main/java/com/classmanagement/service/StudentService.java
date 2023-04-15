package com.classmanagement.service;

import com.classmanagement.entity.Student;
import com.classmanagement.entity.User;

import java.util.List;

public interface StudentService {

    /*返回userId*/
    Integer addStudent(User user, Student student);

    Integer deleteStudentByStudentNum(Integer studentNum);

    Integer updateStudent(Student student);

    Student queryStudentByStudentNum(Integer studentNum);

    List<Student> queryStudentsLimitIn10(Integer page);

    List<Student> queryAllStudents();

    Integer queryStudentIsLeaderByUserId(Integer uid);
    Integer updateStudentIsLeader(Integer uid, Integer isLeader);

}
