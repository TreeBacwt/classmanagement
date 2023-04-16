package com.classmanagement.service.impl;

import com.classmanagement.dao.ParentMapper;
import com.classmanagement.dao.StudentMapper;
import com.classmanagement.dao.TeacherMapper;
import com.classmanagement.dao.UserMapper;
import com.classmanagement.entity.Teacher;
import com.classmanagement.entity.User;
import com.classmanagement.entity.UserWithNameVO;
import com.classmanagement.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    final
    UserMapper userMapper;
    final
    TeacherMapper teacherMapper;
    final
    StudentMapper studentMapper;
    final ParentMapper parentMapper;

    public UserServiceImpl(UserMapper userMapper, TeacherMapper teacherMapper, StudentMapper studentMapper, ParentMapper parentMapper) {
        this.userMapper = userMapper;
        this.teacherMapper = teacherMapper;
        this.studentMapper = studentMapper;
        this.parentMapper = parentMapper;
    }

    @Override
    public User queryUserByAccount(String account) {
        return userMapper.queryUserByAccount(account);
    }

    @Override
    public Integer updatePasswordById(Integer id, String psw) {
        return userMapper.updatePasswordById(id, psw);
    }

    @Override
    public List<User> queryUsersLimitIn10(Integer page) {
        return userMapper.queryUsersLimit((page - 1) * 10, 10);
    }

    @Override
    public User queryUserById(Integer id) {
        return userMapper.queryUserById(id);
    }

    @Override
    public List<User> queryAllUsers() {
        return userMapper.queryAllUsers();
    }

    @Transactional
    @Override
    public Integer deleteUserById(Integer id) {
        User user = userMapper.queryUserById(id);
        Integer role = user.getRole();
        if (role == 1) {
            Teacher teacher = teacherMapper.queryTeacherByUserId(id);
            teacherMapper.deleteTeacherById(teacher.getId());
        } else if (role == 2) {
            studentMapper.deleteStudentByUserId(id);
        } else {
            parentMapper.deleteParentByUserId(id);
        }
        return userMapper.deleteUserById(id);
    }

    @Override
    public List<UserWithNameVO> queryAllUsersWithName() {
        List<User> users = userMapper.queryAllUsers();
        ArrayList<UserWithNameVO> userWithNameVOS = new ArrayList<>();
        for (User user : users) {
            Integer role = user.getRole();
            if (role == 1) {
                userWithNameVOS.add(new UserWithNameVO(user, teacherMapper.queryTeacherByUserId(user.getId()).getTeacherName()));
            } else if (role == 2) {
                userWithNameVOS.add(new UserWithNameVO(user, studentMapper.queryStudentByUserId(user.getId()).getStudentName()));
            } else
                userWithNameVOS.add(new UserWithNameVO(user, parentMapper.queryParentByUserId(user.getId()).getParentName()));
        }
        return userWithNameVOS;
    }
}
