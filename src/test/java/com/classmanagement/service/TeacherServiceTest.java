package com.classmanagement.service;

import com.classmanagement.entity.Teacher;
import com.classmanagement.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TeacherServiceTest {

    @Autowired
    TeacherService teacherService;

    @Test
    void insert(){
        User user = new User("zhaiyuxuan", "123456", 1);
        Teacher teacher = new Teacher("翟宇轩", 1, "计算机", "好好学习");
        System.out.println(teacherService.addTeacher(user, teacher));
    }
}
