package com.classmanagement.service;

import com.classmanagement.entity.User;

public interface UserService {

    public User queryUserByAccount(String account);
}
