package com.classmanagement.service.impl;

import com.classmanagement.dao.ParentMapper;
import com.classmanagement.dao.UserMapper;
import com.classmanagement.entity.Parent;
import com.classmanagement.entity.User;
import com.classmanagement.service.ParentService;
import com.classmanagement.util.Md5Util;
import org.springframework.stereotype.Service;

@Service
public class ParentServiceImpl implements ParentService {

    final
    UserMapper userMapper;
    final
    ParentMapper parentMapper;

    public ParentServiceImpl(UserMapper userMapper, ParentMapper parentMapper) {
        this.userMapper = userMapper;
        this.parentMapper = parentMapper;
    }

    @Override
    public Integer addParent(User user, Parent parent) {
        Md5Util.md5(user);
        userMapper.insertUser(user);
        Integer userId = user.getId();
        parent.setUserId(userId);
        parentMapper.insertParent(parent);
        return userId;
    }

    @Override
    public Integer deleteParentById(Integer id) {
        Integer userId = parentMapper.queryParentById(id).getUserId();
        parentMapper.deleteParentById(id);
        userMapper.deleteUserById(userId);
        return 1;
    }

    @Override
    public Integer updateParent(Parent parent) {
        return parentMapper.updateParent(parent);
    }

    @Override
    public Parent queryParentById(Integer id) {
        return parentMapper.queryParentById(id);
    }
}
