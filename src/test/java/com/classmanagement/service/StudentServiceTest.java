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
        User user = new User("lisi", "123456", 2);
        Student student = new Student("李四", 0, new Date(), "浙江省杭州市", "汉族", "喜喜", 0);
        System.out.println(studentService.addStudent(user, student));
    }

    @Test
    void query(){
        System.out.println(studentService.queryStudentByStudentNum(2));
    }

    @Test
    void update(){
        System.out.println(studentService.updateStudent(new Student(2, "张三二2", 1, 8, new Date(), "浙江省杭州市", "汉族", "happy", 0)));
    }

    @Test
    void delete(){
        System.out.println(studentService.deleteStudentByStudentNum(2));
    }
}
