package com.classmanagement.dao;

import com.classmanagement.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    public Integer insertUser(User user);
    public User queryUserById(Integer id);
    public Integer updateUser(User user);
    public Integer deleteUserById(Integer id);
    public User queryUserByAccount(String account);
    public Integer updatePasswordById(Integer id, String psw);
}
