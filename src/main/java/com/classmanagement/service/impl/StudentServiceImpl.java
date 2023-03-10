package com.classmanagement.service.impl;

import com.classmanagement.dao.StudentMapper;
import com.classmanagement.dao.UserMapper;
import com.classmanagement.entity.Student;
import com.classmanagement.entity.User;
import com.classmanagement.service.StudentService;
import com.classmanagement.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    StudentMapper studentMapper;

    @Override
    public Integer addStudent(User user, Student student) {
        Md5Util.md5(user);
        userMapper.insertUser(user);
        Integer userId = user.getId();
        student.setUserId(userId);
        studentMapper.insertStudent(student);
        return userId;
    }

    @Override
    public Integer deleteStudentByStudentNum(Integer studentNum) {
        Integer userId = studentMapper.queryStudentByStudentNum(studentNum).getUserId();
        studentMapper.deleteStudentByStudentNum(studentNum);//同时删除用户表跟学生表
        userMapper.deleteUserById(userId);
        return 1;
    }

    @Override
    public Integer updateStudent(Student student) {
        studentMapper.updateStudent(student);
        return 1;
    }

    @Override
    public Student queryStudentByStudentNum(Integer studentNum) {
        return studentMapper.queryStudentByStudentNum(studentNum);
    }

}
