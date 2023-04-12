package com.classmanagement.service;

import com.classmanagement.entity.Teacher;
import com.classmanagement.entity.User;

public interface TeacherService {

    Integer addTeacher(User user, Teacher teacher);
    Integer updateTeacher(Teacher teacher);
    Teacher queryTeacherByUserId(Integer uid);

}
