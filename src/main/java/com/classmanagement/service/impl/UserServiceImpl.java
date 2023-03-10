package com.classmanagement.service.impl;

import com.classmanagement.dao.UserMapper;
import com.classmanagement.entity.User;
import com.classmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User queryUserByAccount(String account) {
        return userMapper.queryUserByAccount(account);
    }
}
