package com.classmanagement.dao;

import com.classmanagement.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TeacherMapperTest {

    @Autowired
    TeacherMapper teacherMapper;


    @Test
    void insert(){
        System.out.println(teacherMapper.insertTeacher(new Teacher("zyx", 1, "computer", "hahaha", 1)));
    }

    @Test
    void query(){
        System.out.println(teacherMapper.queryTeacherById(5));
    }

    @Test
    void update(){
        System.out.println(teacherMapper.updateTeacher(new Teacher(2, "zyx", 1, "computer111", "hahaha", 2)));
    }

    @Test
    void delete(){
        System.out.println(teacherMapper.deleteTeacherById(1));
    }
}
