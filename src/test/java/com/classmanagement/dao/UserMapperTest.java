package com.classmanagement.dao;

import com.classmanagement.entity.User;
import com.classmanagement.util.Md5Util;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserMapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    void insert(){
        User user = new User("zyx5", "123456", 1);
        userMapper.insertUser(user);
        System.out.println(user.getId());
    }

    @Test
    void query(){
        //System.out.println(userMapper.queryUserById(1));
        System.out.println(userMapper.queryUsersLimit(0, 5));
    }

    @Test
    void update(){
        //System.out.println(userMapper.updateUser(new User(2, "zyx2", "112233", 1)));
        userMapper.updatePasswordById(1, Md5Util.md5("123456"));
    }

    @Test
    void delete(){
        System.out.println(userMapper.deleteUserById(2));
    }
}
