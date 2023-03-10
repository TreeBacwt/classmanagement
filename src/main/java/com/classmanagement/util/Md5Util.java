package com.classmanagement.util;

import com.classmanagement.entity.User;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

public class Md5Util {

    /*用户密码加密*/
    public static void md5(User user){
        user.setPassword(md5(user.getPassword()));
    }

    public static String md5(String s){
        return DigestUtils.md5DigestAsHex(s.getBytes(StandardCharsets.UTF_8));
    }

    public static Boolean verify(String clear, String psw){
        return psw.equalsIgnoreCase(md5(clear));
    }
}
