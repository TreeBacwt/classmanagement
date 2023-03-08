package com.classmanagement.service.impl;

import com.classmanagement.dao.StudentMapper;
import com.classmanagement.dao.UserMapper;
import com.classmanagement.entity.Student;
import com.classmanagement.entity.User;
import com.classmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    StudentMapper studentMapper;


    @Override
    public Integer addStudent(User user, Student student) {
        try {
            userMapper.insertUser(user);
            Integer userId = user.getId();
            student.setUserId(userId);
            studentMapper.insertStudent(student);
            return userId;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
