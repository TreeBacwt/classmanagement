package com.classmanagement.service;

import com.classmanagement.entity.Student;
import com.classmanagement.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class StudentServiceTest {

    @Autowired
    StudentService studentService;

    @Test
    void add(){
        User user = new User("zhangsan2", "123456", 2);
        Student student = new Student("张三二", 1, new Date(), "浙江省杭州市", "汉族", "happy", 0);
        System.out.println(studentService.addStudent(user, student));
    }
}
