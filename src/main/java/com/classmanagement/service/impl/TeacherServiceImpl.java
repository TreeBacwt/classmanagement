package com.classmanagement.service.impl;

import com.classmanagement.dao.TeacherMapper;
import com.classmanagement.dao.UserMapper;
import com.classmanagement.entity.Teacher;
import com.classmanagement.entity.User;
import com.classmanagement.service.TeacherService;
import com.classmanagement.util.Md5Util;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {

    final
    UserMapper userMapper;
    final
    TeacherMapper teacherMapper;

    public TeacherServiceImpl(UserMapper userMapper, TeacherMapper teacherMapper) {
        this.userMapper = userMapper;
        this.teacherMapper = teacherMapper;
    }

    @Override
    public Integer addTeacher(User user, Teacher teacher) {
        Md5Util.md5(user);
        userMapper.insertUser(user);
        Integer userId = user.getId();
        teacher.setUserId(userId);
        teacherMapper.insertTeacher(teacher);
        return userId;
    }

    @Override
    public Integer updateTeacher(Teacher teacher) {
        return teacherMapper.updateTeacher(teacher);
    }

    @Override
    public Teacher queryTeacherByUserId(Integer uid) {
        return teacherMapper.queryTeacherByUserId(uid);
    }
}
