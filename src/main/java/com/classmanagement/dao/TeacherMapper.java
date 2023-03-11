package com.classmanagement.dao;

import com.classmanagement.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeacherMapper {
    Integer insertTeacher(Teacher teacher);
    Teacher queryTeacherById(Integer id);
    Integer updateTeacher(Teacher teacher);
    Integer deleteTeacherById(Integer id);
}
