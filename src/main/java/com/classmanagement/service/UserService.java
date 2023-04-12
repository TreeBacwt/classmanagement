package com.classmanagement.service;

import com.classmanagement.entity.User;

import java.util.List;

public interface UserService {

    User queryUserByAccount(String account);
    Integer updatePasswordById(Integer id, String psw);
    List<User> queryUsersLimitIn10(Integer page);
    User queryUserById(Integer id);
}
