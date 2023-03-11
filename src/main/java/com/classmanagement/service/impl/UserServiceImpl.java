package com.classmanagement.service.impl;

import com.classmanagement.dao.UserMapper;
import com.classmanagement.entity.User;
import com.classmanagement.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    final
    UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User queryUserByAccount(String account) {
        return userMapper.queryUserByAccount(account);
    }

    @Override
    public Integer updatePasswordById(Integer id, String psw) {
        return userMapper.updatePasswordById(id, psw);
    }
}
