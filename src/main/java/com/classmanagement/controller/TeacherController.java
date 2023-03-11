package com.classmanagement.controller;

import com.classmanagement.entity.Teacher;
import com.classmanagement.service.TeacherService;
import com.classmanagement.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @PutMapping("/upd")
    public Result updateTeacher(Teacher teacher){
        Integer updateTeacher = teacherService.updateTeacher(teacher);
        if (updateTeacher == 1) {
            return Result.success("信息更新成功！");
        }else return Result.fail("信息更新失败！");
    }
}
