package com.classmanagement.service;

import com.classmanagement.entity.Teacher;
import com.classmanagement.entity.User;

public interface TeacherService {

    public Integer addTeacher(User user, Teacher teacher);
    public Integer updateTeacher(Teacher teacher);

}
