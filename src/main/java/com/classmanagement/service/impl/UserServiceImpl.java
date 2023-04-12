package com.classmanagement.service.impl;

import com.classmanagement.dao.UserMapper;
import com.classmanagement.entity.User;
import com.classmanagement.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<User> queryUsersLimitIn10(Integer page) {
        return userMapper.queryUsersLimit((page - 1) * 10, 10);
    }

    @Override
    public User queryUserById(Integer id) {
        return userMapper.queryUserById(id);
    }
}
