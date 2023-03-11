package com.classmanagement.dao;

import com.classmanagement.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    Integer insertUser(User user);
    User queryUserById(Integer id);
    Integer updateUser(User user);
    Integer deleteUserById(Integer id);
    User queryUserByAccount(String account);
    Integer updatePasswordById(Integer id, String psw);
}
