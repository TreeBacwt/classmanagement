package com.classmanagement.service.impl;

import com.classmanagement.dao.StudentMapper;
import com.classmanagement.dao.UserMapper;
import com.classmanagement.entity.Student;
import com.classmanagement.entity.User;
import com.classmanagement.service.StudentService;
import com.classmanagement.util.Md5Util;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    final
    UserMapper userMapper;
    final
    StudentMapper studentMapper;

    public StudentServiceImpl(UserMapper userMapper, StudentMapper studentMapper) {
        this.userMapper = userMapper;
        this.studentMapper = studentMapper;
    }

    @Transactional
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
        return studentMapper.updateStudent(student);
    }

    @Override
    public Student queryStudentByStudentNum(Integer studentNum) {
        return studentMapper.queryStudentByStudentNum(studentNum);
    }

    @Override
    public List<Student> queryStudentsLimitIn10(Integer page) {
        return studentMapper.queryStudentsLimit((page - 1) * 10, 10);
    }

    @Override
    public List<Student> queryAllStudents() {
        return studentMapper.queryAllStudents();
    }

    @Override
    public Integer queryStudentIsLeaderByUserId(Integer uid) {
        return studentMapper.queryStudentByUserId(uid).getIsLeader();
    }

    @Override
    public Integer updateStudentIsLeader(Integer uid, Integer isLeader) {
        return studentMapper.updateStudentIsLeader(uid, isLeader);
    }

    @Override
    public Student queryStudentByUserId(Integer uid) {
        return studentMapper.queryStudentByUserId(uid);
    }

}
