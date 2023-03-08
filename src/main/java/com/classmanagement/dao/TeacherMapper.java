package com.classmanagement.dao;

import com.classmanagement.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeacherMapper {
    public Integer insertTeacher(Teacher teacher);
    public Teacher queryTeacherById(Integer id);
    public Integer updateTeacher(Teacher teacher);
    public Integer deleteTeacherById(Integer id);
}
