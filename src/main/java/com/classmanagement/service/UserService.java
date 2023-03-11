package com.classmanagement.service;

import com.classmanagement.entity.User;

public interface UserService {

    User queryUserByAccount(String account);
    Integer updatePasswordById(Integer id, String psw);
}
